package progetto.model.premio;



import progetto.model.mario.Mario;



public interface Premio {
	int getPunti();

    void rivela();

   

    void collision(Mario mario);
}
