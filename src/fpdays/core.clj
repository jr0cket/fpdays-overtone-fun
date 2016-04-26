
(ns fpdays.core
  (:use [overtone.live]))

;; [overtone.inst.sample-piano]


;(piano 48)
; (sample-piano 48 )

;(chord :c4 :major)

(comment
  (defn foo []
    (dorun
     (map #(piano %) (chord :c4 :minor)))))

;; dorun forces evaluation



(defsynth noise []
  (out 0 (normalizer (lpf (saw [100 102]) 300))))

(noise)
(noise 100)
(def n (noise 100))
(kill n)
(ctl n :freq 150)
(stop)

(map #(do (ctl n %
               )
          (Thread/Sleep 200))
     (scale :c4 :pentatonic))


(event-debug off)

(on-event [:midi :note-on]
          (fn [msg]
               (println (:note msg)))
            ::foo)

;; using double colon the keyword is namespace specific
;; so it avoids clashes


;;; demo on the command line

;(demo (sin-osc))


;(demo (saw))


;(demo (saw [100 102]))


;(demo (lpf (saw [100 102]) 300))


;(demo (normalizer (lpf (saw [100 102]) 300)))


;(macroexpand '(demo (normalizer (lpf (saw [100 102]) 300))))


;; The backwards quote give you the function and the namespace,
; the normal quote just give you the function
; (+ 1 2)
; '(+ 1 2)
; `(+ 1 2)
;(macroexpand)
