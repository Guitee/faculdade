import java.util.*;
import java.io.*;

class Q05
{
  public static String separar (String cadeia)
  {  
    String resp = ""; 

     for(int i = 0; i < cadeia.length() ; i++ )
     {
        if(cadeia.charAt(i) != ' ')
        {
           resp += cadeia.charAt();        
        }	
     }  
    return separar;
  }//fim separar

  	


  public static void main (String [] args)
   {
      String entrada[]= new String[1000];
      
      int numEntrada = 0;
      
      //Leitura da entrada padrao
      do 
      {
         entrada[numEntrada] = MyIO.readLine();
         
      } while (entrada[numEntrada++].equals("FIM") == false);
      
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      for(int i = 0; i < numEntrada; i+=2)
      {
         html(entrada[i] ,entrada[i + 1]);    
         
      }   
         
   }// fim main 	
}// fim class Q05
