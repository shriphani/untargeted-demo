(ns untargeted-demo.core
  (:require [subotai.warc.warc :as warc]
            [subotai.structural-similarity :refer :all]))

(def original-api-url "https://cookpad.com/en/recipes/171932-wheat-bran-and-walnut-bagels?ref=category")

(def original-pg-source (slurp "source_pg.html"))

(defn get-pages-like-source
  [warc-file]
  (let [warc-stream (warc/warc-input-stream warc-file)
        records     (warc/stream-html-records-seq warc-stream)]
    (doall
     (doseq [record records]
       (let [payload (:payload record)]
         (if (similar? payload original-pg-source)
           (println (:warc-target-uri record))))))))

(defn dump-all-urls
  [warc-file]
  (let [warc-stream (warc/warc-input-stream warc-file)
        records     (warc/stream-html-records-seq warc-stream)]
    (doall
     (doseq [record records]
       (let [payload (:payload record)]
         (println (:warc-target-uri record)))))))

(defn -main
  [& args]
  (let [warc-file (first args)]
    (dump-all-urls warc-file)))
