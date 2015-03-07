#!/usr/bin/env bash
# Bash3 Boilerplate. Copyright (c) 2014, kvz.io

set -o errexit
set -o pipefail
set -o nounset
set -o xtrace

ONYX_REV=$1
BENCHMARK_REV=$2
RUN_ID=$3
VPEERS=$4

DEPLOYMENT_ID=$ONYX_REV"_"$BENCHMARK_REV"_"$RUN_ID

killall -9 java || true

export LEIN_ROOT=1

# update repo again since the other task might no be run if some other variables change?
# investigate later
./update_repo.sh $BENCHMARK_REV

cd /onyx
git checkout .
git clean -f
git checkout master
git fetch --all 
git pull --all 
git checkout $ONYX_REV
lein clean
lein install

cd /onyx-benchmark

ZOOKEEPER_ADDR=$(cat /home/ubuntu/zookeeper.txt)

lein clean && lein run -m onyx-benchmark.peer $ZOOKEEPER_ADDR $DEPLOYMENT_ID $VPEERS &