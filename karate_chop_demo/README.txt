A binary chop (sometimes called the more prosaic binary search) finds the position of value in a sorted array of values. It achieves some efficiency by halving the number of items under consideration each time it probes the values: in the first pass it determines whether the required value is in the top or the bottom half of the list of values. In the second pass in considers only this half, again dividing it in to two. It stops when it finds the value it is looking for, or when it runs out of array to search. Binary searches are a favorite of CS lecturers.

1 - fai tutto in un unico test con metodo statico
2 - estrai la class
3 - da statico fai metodo di istanza
4 - estrai un'interfaccia
5 - duplica il test e realizza la versione ricorsiva

REFACTORING
-1 come ELEMENT_NOT_FOUND
metodo per verificare l'array sia vuoto...