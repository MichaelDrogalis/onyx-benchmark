(defproject onyx-benchmark "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  ;"-Daeron.rcv.buffer.length=100000" "-Daeron.socket.so_sndbuf=320000" "-Daeron.socket.so_rcvbuf=320000"  "-Daeron.term.buffer.length=131072" "-Daeron.rcv.initial.window.length=131072"]
  :java-opts ["-server" "-Xmx2g"]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars  {*warn-on-reflection* true *assert* false}
  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [io.netty/netty-all "4.0.25.Final"]
                 [org.clojure/data.fressian "0.2.0"]
                 [com.mdrogalis/onyx "0.6.0-SNAPSHOT"]
                 [riemann-clojure-client "0.3.2" :exclusions [io.netty/netty]]
                 [cheshire "5.4.0"]])
