(ns dcaas.survey-renderer.renderer
  (:require [clojure.xml :as xml]
            [clojure.string :as s]))

(defn- escape-str
  [string]
  string)

(defn- whitespaceless
  [string]
  (s/replace string #"\s+" (fn [[_]] " ")))

(defn compile-survey-descriptor
  [uri]
  nil)


(defn- render-h1
  [content]
  (str
    "<h1>"
    (escape-str (apply str content))
    "</h1>"))

(defn- render-h2
  [content]
  (str
    "<h2>"
    (escape-str (apply str content))
    "</h2>"))

(defn- render-h3
  [content]
  (str
    "<h3>"
    (escape-str (apply str content))
    "</h3>"))

(defn- render-h4
  [content]
  (str
    "<h4>"
    (escape-str (apply str content))
    "</h4>"))

(defn- render-h5
  [content]
  (str
    "<h5>"
    (escape-str (apply str content))
    "</h5>"))

(defn- render-h6
  [content]
  (str
    "<h6>"
    (escape-str (apply str content))
    "</h6>"))

(defn- render-b
  [content]
  (str
    "<b>"
    (escape-str (apply str content))
    "</b>"))

(defn- render-i
  [content]
  (str
    "<i>"
    (escape-str (apply str content))
    "</i>"))

(defn- render-u
  [content]
  (str
    "<u>"
    (escape-str (apply str content))
    "</u>"))

(defn- render-a
  [content href]
  (str
    "<a href=\"" (escape-url href) "\">"
    (escape-str (apply str content))
    "</a>"))

(defn- render-code
  [content]
  (str
    "<code>"
    (escape-str (apply str content))
    "</code>"))


(defn- render-br
  [content]
  (str
    "<br>"
    (escape-str (apply str content))
    "</br>"))

(defn- render-hr
  [content]
  (str
    "<hr>"
    (escape-str (apply str content))
    "</hr>"))

(defn- render-ul
  [content]
  (str
    "<ul>"
    (escape-str (apply str content))
    "</ul>"))

(defn- render-ol
  [content]
  (str
    "<ol>"
    (escape-str (apply str content))
    "</ol>"))

(defn- render-p
  [content]
  (str
    "<p>"
    (escape-str (apply str content))
    "</p>"))

(defn- render-sub
  [content]
  (str
    "<sub>"
    (escape-str (apply str content))
    "</sub>"))

(defn- render-sup
  [content]
  (str
    "<sup>"
    (escape-str (apply str content))
    "</sup>"))

(defn- render-short-answer
  [content name]
  (whitespaceless (str
    "<b>"
    (escape-str (apply str content))
    "</b>"
    "<div class=\"row\">
      <div class=\"col-md-3\"></div>
      <div class=\"col-md-6\">
        <label for=\"short-answer\">Short answer</label>
        <input type=\"text\" class=\"form-control\" id=\"" name "\">
      </div>
      <div class=\"col-md-3\"></div>
    </div>")))

(defn- render-survey-elements
  [elems]
  (apply str
    (map #(match [(:tag %)]
      [:h1] (render-h1 (:content %))
      [:h2] (render-h2 (:content %))
      [:h3] (render-h3 (:content %))
      [:h4] (render-h3 (:content %))
      [:h5] (render-h3 (:content %))
      [:h6] (render-h3 (:content %))
      [:b] (render-b (:content %))
      [:i] (render-i (:content %))
      [:u] (render-u (:content %))
      [:a] (render-a (:content %) (-> % :attrs :href))
      [:code] (render-code (:content %))
      [:br] (render-br (:content %))
      [:hr] (render-hr (:content %))
      [:ul] (render-ul (:content %))
      [:ol] (render-ol (:content %))
      [:p] (render-p (:content %))
      [:sub] (render-sub (:content %))
      [:sup] (render-sup (:content %))
      [:short-answer] (render-short-answer (:content %))
      [:long-answer] (render-long-answer (:content %))
      [:checkboxes] (render-checkboxes (:content %))
      [:datepicker] (render-datepicker (:content %))
      [:timepicker] (render-timepicker (:content %))
      [:natural-language-date-time] (render-natural-language-date-time (:content %))
      [:multiple-choice] (render-multiple-choice (:content %))
      [:linear-scale] (render-linear-scale (:content %))
      [:multiple-choice-grid] (render-multiple-choice-grid (:content %))
      [:dropdown] (render-dropdown (:content %))
      :else nil))))

(defn render-survey
  [uri]
  (let [xml (xml/parse uri)]
    (if (= (:tag xml) :survey)
      (render-survey-elements (:content xml))
      nil))
