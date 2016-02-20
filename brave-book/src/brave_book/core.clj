(ns brave-book.core
	(:gen-class))


(defn linear-search
	[vet number]
	(for [i (range (count vet))]
		(if (= (get vet i) number)
			(println (str "\nEncontrado na posicao: " i "\n"))
		)
	)
)

(defn linear-search-rec
	[vet number]
	(loop [i (count vet)]
		(if (= i 0)
			(println "numero nao encontrado")
			(if (= (get vet i) number)
				(println (str "Numero na posicao: " i))
				(recur (dec i))
			)
		)
	)
)