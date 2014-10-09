JCC = javac
JFLAGS = -g

default: Elemento.class Enemigo.class Enemigo_Horizontal.class Enemigo_Lineal.class Enemigo_Vertical.class Enemigo_Reloj.class Enemigo_Contra_Reloj.class Game.class Mapa.class Puerta.class Switch.class Usuario.class 

Elemento.class: Elemento.java
	$(JCC) $(JFLAGS) Elemento.java

Enemigo.class: Enemigo.java
	$(JCC) $(JFLAGS) Enemigo.java

Enemigo_Horizontal.class: Enemigo_Horizontal.java
	$(JCC) $(JFLAGS) Enemigo_Horizontal.java

Enemigo_Lineal.class: Enemigo_Lineal.java
	$(JCC) $(JFLAGS) Enemigo_Lineal.java

Enemigo_Vertical.class: Enemigo_Vertical.java
	$(JCC) $(JFLAGS) Enemigo_Vertical.java

Enemigo_Reloj.class: Enemigo_Reloj.java
	$(JCC) $(JFLAGS) Enemigo_Reloj.java

Enemigo_Contra_Reloj.class: Enemigo_Contra_Reloj.java
	$(JCC) $(JFLAGS) Enemigo_Contra_Reloj.java

Game.class: Game.java
	$(JCC) $(JFLAGS) Game.java

Mapa.class: Mapa.java
	$(JCC) $(JFLAGS) Mapa.java

Puerta.class: Puerta.java
	$(JCC) $(JFLAGS) Puerta.java

Switch.class: Switch.java
	$(JCC) $(JFLAGS) Switch.java

Usuario.class: Usuario.java
	$(JCC) $(JFLAGS) Usuario.java

clean: 
	$(RM) *.class
