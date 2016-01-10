Map, ja siihen kuuluvat Rectangle ja Line luodaan aivan aluksi karttatiedoston pohjalta. 
Tästä on vastuussa MapCreator, joka kutsuu pakettinsa muita luokkia tehdäkseen hommansa.
Map siis sisältää tiedot pelattavasta kartasta. Game, joka luodaan Mapin pohjalta sisältää
tiedot pelattavasta pelistä; aloitus-Unitit ja kartan. Pelin pohjalta luodaan Draw-olio, joka
piirtää kulloisenkin pelitilanteen ja vastaa komentojen havaitsemisesta ja niiden toteutuksen
alullepanosta. Main-metodi käynnistää sekä Gamen että Refresherin, jotka pyörittävät
pelilogiikkaa ja päivittävät Drawia, tässä järjestyksessä.
