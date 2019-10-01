import java.util.Random;

class Q04
{
   static Random g = new Random();
   
  //Metodo que altera duas letras de uma string 
   public static String alterar (String c)
   {
      String s = "";
      int t = c.length();
      char a = ( char ) ( 'a' + (Math.abs( g.nextInt( ) ) % 26 ) );
      char b = ( char ) ( 'a' + (Math.abs( g.nextInt( ) ) % 26 ) );
      // MyIO.println( a + " " +  b);  teste
      
      for(int i = 0; i < t; i++)
      {
         if(c.charAt(i) == a)
         {
           s+= b;  
         }
         else
         {
            s+= c.charAt(i); 
         }              
      }
      return s;  
   
   }// fim alterar()
   
   public static void main (String [] args)
   {
      String[] entrada = new String[1000];
      String linha,  r ;
      int numEntrada = 0;
      g.setSeed(4);

      //Leitura da entrada padrao
      do 
      {
         entrada[numEntrada] = MyIO.readLine();
         
      } while (entrada[numEntrada++].equals("FIM") == false);
      
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      for(int i = 0; i < numEntrada; i++)
      {
         r = alterar(entrada[i]);
         MyIO.println(r);
         MyIO.println();
      }
   }// fim main
    
}// fim class Q04
