import java.io.*;
  import java.time.*;
import java.time.format.*;
import java.util.*;

class Presidente
{
   //Atributos da classe
   private int id;
   private String nome;
   private int idade;
   private LocalDate dataNascimento;
   private String localNascimento;
   private LocalDate inicioMandato;
   private LocalDate fimMandato;
   private LocalDate dataMorte;
   private String localMorte;
   private String antecessor;
   private String sucessor;
   private String vice;
   private String pagina;
   private long paginaTam;

   //Construtores

   public Presidente()
   {	
     this.id = 0;
     this.nome = "";
     this.idade = 0;
     this.dataNascimento = null;
     this.localNascimento = "";
     this.inicioMandato = null;
     this.fimMandato = null;
     this.dataMorte = null;
     this.localMorte = "";
     this.antecessor = "";
     this.sucessor = "";
     this.vice = "";
     this.pagina = "";
     this.paginaTam = 0;   	

   }//fim construtor padrao

   public Presidente(int id, String nome, int idade , LocalDate dataNascimento, String localNascimento, LocalDate inicioMandato, 
   	LocalDate fimMandato, LocalDate dataMorte, String localMorte, String antecessor, String sucessor, String vice,
   	String pagina, long paginaTam )
   {
      this.id = id;
      this.nome = nome;
      this.idade = idade;
      this.dataNascimento = dataNascimento;
      this.localNascimento = localNascimento;
      this.inicioMandato = inicioMandato;
      this.fimMandato = fimMandato;
      this.dataMorte = dataMorte;
      this.localMorte = localMorte;
      this.antecessor = antecessor;
      this.sucessor = sucessor;
      this.vice = vice;
      this.pagina = pagina;
      this.paginaTam = paginaTam;    
 
   }//fim construtor alternativo()    	
   
   //getters

   public int getId()
   {
      return(id);	
   }//fim getID
   
   public String getNome()
   {
      return(nome);	
   }//fim geNome

   public int getIdade()
   {
      return(idade);	
   }//fim getID
   
   public LocalDate getDataNascimento()
   {
      return(dataNascimento);	
   }//fim getDataNascimento

   public String getLocalNascimento()
   {
      return(localNascimento);	
   }//fim getLocalNascimento
   
   public LocalDate getInicioMandato()
   {
      return(inicioMandato);	
   }//fim getInicioMandato

   public LocalDate getFimMandato()
   {
      return(fimMandato);	
   }//fim getFimMandato

   public LocalDate getDataMorte()
   {
      return(dataMorte);	
   }//fim getDataMorte

   public String getLocalMorte()
   {
      return(localMorte);	
   }//fim getLocalMorte

   public String getAntecessor()
   {
      return(antecessor);	
   }//fim getAntecessor

   public String getSucessor()
   {
      return(sucessor);	
   }//fim getSucessor
   
   public String getVice()
   {
      return(vice);	
   }//fim getVice 

   public String getPagina()
   {
      return(pagina);	
   }//fim getPagina

   public long getPaginaTam()
   {
      return(paginaTam);	
   }//fim getPaginaTam

   //setters

   public void setId ( int id )
   {
      this.id = id; 
   }//fim setID
   
   public void setNome ( String nome )
   {
      this.nome = nome; 
   }//fim setnome

   public void setIdade ( int idade )
   {
      this.idade = idade; 
   }//fim setID
   
   public void setDataNascimento ( LocalDate dataNascimento )
   {
      this.dataNascimento = dataNascimento; 
   }//fim setDataNascimento
   
   public void setLocalNascimento (String localNascimento)
   {
      this.localNascimento = localNascimento; 
   }//fim setLocalNascimento
   
   public void setInicioMandato (LocalDate inicioMandato)
   {
      this.inicioMandato = inicioMandato; 
   }//fim setInidicioMandato

   public void setFimMandato ( LocalDate fimMandato)
   {
      this.fimMandato = fimMandato; 
   }//fim setFimMandato

   public void setDataMorte ( LocalDate dataMorte)
   {
      this.dataMorte = dataMorte; 
   }//fim setDataMorte

   public void setLocalMorte ( String localMorte)
   {
      this.localMorte = localMorte; 
   }//fim setLocalMorte

   public void setAntecessor ( String antecessor )
   {
      this.antecessor = antecessor; 
   }//fim setAntecessor

   public void setSucessor( String sucessor)
   {
      this.sucessor = sucessor; 
   }//fim setSucessor

   public void setVice ( String vice)
   {
      this.vice = vice; 
   }//fim setVIce

   public void setPagina (String pagina )
   {
      this.pagina = pagina; 
   }//fim setPagina

   public void setPaginaTam(long paginaTam)
   {
      this.paginaTam = paginaTam; 
   }//fim setPaginaTam

   public static Presidente ler (String url)throws Exception 
   {
      Presidente pre = new Presidente ();
      String aux1 = "";
      String aux2 = "";
      String linha = "";     
      File fr = new File (url);
      BufferedReader br = new BufferedReader (new FileReader(fr));
      linha = br.readLine();

     while(!linha.contains("Presidente do Brasil"))
      {
        linha = br.readLine();    
      }
          
      aux1 = tirarTags(linha);
      aux2 = lerId(aux1);
      pre.setId(Integer.parseInt(aux2));

      while(!linha.contains("Per"))
      {
         linha = br.readLine(); 
      }
      linha = br.readLine();
      linha = br.readLine();
      aux1 = tirarTags(linha);
      pegarDatasMandato(aux1,pre);

      while (!linha.contains("Vice-presidente")) 
      {
        if (linha.contains("Antecessor")) 
        {
          linha = br.readLine();
          linha = br.readLine();
          aux1 = tirarTags(linha);
          pre.setAntecessor(aux1);

          if (!url.equals("/tmp/presidente/Jair_Bolsonaro.html")) 
          {
            while (!linha.contains("Sucessor")) 
            {
              linha = br.readLine();
            }

            linha = br.readLine();
            linha = br.readLine();
            aux1 = tirarTags(linha);
            pre.setSucessor(aux1);
          }
        }
        linha = br.readLine();
      }

      linha = br.readLine();
      linha = br.readLine();
      aux1 = tirarTags(linha);
      pre.setVice(aux1);

      if (pre.getVice().equals("") == false) 
      {
        while (!linha.contains("Antecessor")) 
        {
          linha = br.readLine();
        }

        linha = br.readLine();
        linha = br.readLine();
        aux1 = tirarTags(linha);
        pre.setAntecessor(aux1);

        if (!url.equals("/tmp/presidente/Jair_Bolsonaro.html")) 
        {
          while (!linha.contains("Sucessor")) 
          {
            linha = br.readLine();
          }

          linha = br.readLine();
          linha = br.readLine();
          aux1 = tirarTags(linha);
          pre.setSucessor(aux1);
        }
      }

      while(!linha.contains("Nome completo"))
      {
      	linha = br.readLine();
      }
      linha = br.readLine();
      linha = br.readLine();
      aux1 = tirarTags(linha);
      pre.setNome(aux1);

      while(!linha.contains("Nascimento"))	
      {
         linha = br.readLine(); 
      }
      linha = br.readLine();
      linha = br.readLine();
      aux1 = tirarTags(linha);
      pegarNascimento(aux1,pre);
      
      boolean flag = false;

      while (!linha.contains("Morte") && !linha.contains("Partido"))
      { 
         linha = br.readLine(); 

         if(linha.contains("Morte"))
         {
            linha = br.readLine();
            linha = br.readLine();
            aux1 = tirarTags(linha);
            flag = true;
            pegarMorte(aux1,pre);
          } 
      }
      if(flag == false)
      {
        pre.setDataMorte(LocalDate.of(0, 1,1));
      }   
     
      br.close();
      pre.setIdade(2019 - pre.getDataNascimento().getYear());
      pre.setPaginaTam(fr.length());
      pre.setPagina(url);

      return pre;
   }//fim ler()

   public static LocalDate arrumarData(String linha)
   {
      LocalDate data;
      int i = 0;
      String dia = "";
      String mes = "";
      String ano = ""; 
      String separar [] = linha.split(" ");

      if(linha.charAt(0) == ' ')
      {
        dia = separar[1];
        mes = separar[3].substring(0,3);
        ano = separar[5];  
      }
      else
      {
        dia = separar[0];
        mes = separar[2].substring(0,3);
        ano = separar[4];
      } 
      dia = tirarBolinha(dia);
      data = LocalDate.of(Integer.parseInt(ano), numMes(mes), Integer.parseInt(dia));
      return data;
   }//fim arrumarData()

   public static String tirarBolinha (String l) // metodo para tirar º 
   {
      String resp = "";
             
      if(!(l.charAt(l.length()-1) >= '0' && l.charAt(l.length()-1) <= '9'))
      {
         for(int i = 0; i < l.length()-1; i++)
         {
          resp += l.charAt(i);
         } 
      }
      else
      {
         resp = l;   
      }  
      return resp;      
   }// fim tirarBolinha()
   
   public static void pegarMorte(String linha, Presidente p)
   {//12deagostode1949(69anos)RiodeJaneiro,DistritoFederal  tem q ficar , DistritoFederal
      String local = "";
      LocalDate dataMorte;
            
      String separar [] = linha.split(" ");

      if(separar[4].contains("anos"))
      { 
         String teste = separar[4].substring(4,12);
         dataMorte = LocalDate.of(Integer.parseInt(separar[4].replace(teste,"")), numMes(separar[2].substring(0,3)), Integer.parseInt(separar[0]));       
      }
      else
      {
         dataMorte = LocalDate.of(Integer.parseInt(separar[4]), numMes(separar[2].substring(0,3)), Integer.parseInt(separar[0])); 
      }

      p.setDataMorte(dataMorte);

      local = separar[5];

      for(int i = 6; i < separar.length; i++)
      {
         local +=  " " + separar[i] ;  
      }
      
      p.setLocalMorte(local); 
    }//fim pegarMorte

   public static void pegarNascimento(String linha, Presidente p)
   {//12deagostode1949(69anos)RiodeJaneiro,DistritoFederal  tem q ficar , DistritoFederal
      String local = "";
      LocalDate dataNas;
      String separar [] = linha.split(" ");

      if(separar[4].contains("anos"))
      { 
         String teste = separar[4].substring(4,12);
         dataNas = LocalDate.of(Integer.parseInt(separar[4].replace(teste,"")), numMes(separar[2].substring(0,3)), Integer.parseInt(separar[0]));       
      }
      else
      {
         dataNas = LocalDate.of(Integer.parseInt(separar[4]), numMes(separar[2].substring(0,3)), Integer.parseInt(separar[0])); 
      }

      p.setDataNascimento(dataNas);

      local = separar[5];

      for(int i = 6; i < separar.length; i++)
      {
         local +=  " " + separar[i] ;  
      }
      
      p.setLocalNascimento(local); 
    }//fim pegarNascimento

   public static void pegarDatasMandato (String linha, Presidente p) // ira separar a data do inicio do mandato, data de nascimento , data de morte
   {  
     String inicio = "";
     String fim = "";
     int flag = 0;
    
    for(int i = 0; i < linha.length(); i++)
    {
      if(linha.charAt(i) == 'a' && linha.charAt(i+2) >= '0' && linha.charAt(i+2) <= '9' )
      {
         flag = i;
         i = linha.length();   
      }
      else if(linha.charAt(i) == 'a' && linha.charAt(i+1) == 't' )
      {
         flag = i + 3;
         i = linha.length();   
      }
      else
      {
        inicio += linha.charAt(i);
      }  
    }
         
    for(int i = flag + 1; i < linha.length(); i++)
    {
      if(linha.charAt(i) == '[')
      {
         i = linha.length();    
      }
      else
      {
        fim += linha.charAt(i);
      }  
    }
     p.setFimMandato(arrumarData(fim));
     p.setInicioMandato(arrumarData(inicio));
            
    }//fim lerLinha()
      
   public void imprimir()
   {
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
      MyIO.print(this.getId()+
                 " ## "+
                 this.getNome()+
                 " ## "+
                 this.getInicioMandato().format(formato)+
                 " (I) ## "+
                 this.getFimMandato().format(formato)+
                 " (F) ## "+
                 this.getDataNascimento().format(formato)+
                 " em "+
                 this.getLocalNascimento()+
                 " (N) ## "+
                 this.getIdade()+
                 " ## ");

      if(this.getDataMorte().getYear() != 0)
      {
         MyIO.print(this.getDataMorte().format(formato)+
                    " em "+
                    this.getLocalMorte()+
                    " (M) ## ");
      }
      MyIO.print(this.getPagina()+
                 " ## "+
                 this.getPaginaTam()+
                 " ## "+
                 this.getAntecessor()+
                 " ## "+
                 this.getSucessor()+
                 " ## "+
                 this.getVice()+
                 "\n");
   }//fim imprimir
      
   public static String lerId(String linha)
   {
      String resp = "";
      int i = 0;
      while(i < linha.length() && linha.charAt(i) >= '0' && linha.charAt(i) <= '9')
      {
         resp += linha.charAt(i);
         i++;
      }
      return resp;
   }//end lerID
   
   public static int numMes (String mes)
   {
      int m = 0;
      
      switch(mes)
      {
      	case "jan":
      	  m = 1;
      	  break;

      	case "fev":
      	  m = 2;
      	  break;

      	case "mar":
      	  m = 3;
      	  break;

      	case "abr":
      	  m = 4;
      	  break;

      	case "mai":
      	  m = 5;
      	  break;

      	case "jun":
      	  m = 6;
      	  break;

      	case "jul":
      	  m = 7;
      	  break;
      	  
      	case "ago":
      	  m = 8;
      	  break;
      	  
      	case "set":
      	  m = 9;
      	  break;

      	case "out":
      	  m = 10;
      	  break;

      	case "nov":
      	  m = 11;
      	  break;

      	case "dez":
      	  m = 12;
      	  break;

      }
      return m;	

   }// fim numMes()

   public static String tirarTags (String linha)
   {
      String resp = ""; 
      
      for(int i = 0; i < linha.length(); i++)
      {
         if(linha.charAt(i) == '<')
         {
         	 while(i < linha.length() && linha.charAt(i) != '>')
         	 { i++; }
         }
         else
         {  resp += linha.charAt(i); }           
      }
      
      resp = resp.replaceAll("  "," ");
      resp = resp.replaceAll("nota [1]","");
      resp = resp.replaceAll("&#32","");
      resp = resp.replaceAll("&#160","");
      resp = resp.replaceAll(";","");

      return resp; 
   }//fim tirarTags

   public Presidente clone ()
   {
      Presidente copia = new Presidente (this.id, this.nome, this.idade,  this.dataNascimento, this.localNascimento, 
        this.inicioMandato, this.fimMandato, this.dataMorte, this.localMorte, this.antecessor, this.sucessor , 
        this.vice, this.pagina, this.paginaTam );
  
      return copia; 

   }//fim clone
  }//fim class presidente

  class Lista 
{
   private Presidente[] array;
   private int n;
 
   //Construtor da classe.
    
   public Lista () 
   {
      this(150);
      n = 0;
   }// fim construtor da classe
   
   //Construtor alternativo da classe (tamanho).
      
   public Lista (int tamanho)
   {
      array = new Presidente [tamanho];
      n = 0;
   }// fim construtor alternativo(tamanho)
 
   public void inserirInicio(Presidente p) throws Exception
    {
      //validar insercao
      if(n >= array.length)
      {
         throw new Exception("Erro ao inserir!");
      } 
      //levar elementos para o fim do array
      for(int i = n; i > 0; i--)
      {
         array[i] = array[i-1];
      }
 
      array[0] = p;
      n++;
   }//fim inserirInicio()
  
   public void inserirFim(Presidente p) throws Exception 
   {
      //validar insercao
      if(n >= array.length)
      {
         throw new Exception("Erro ao inserir!");
      }
 
      array[n] = p;
      n++;
   }// fim inserirFim()

    public void inserir( int pos, Presidente p) throws Exception 
   {
       //validar insercao
      if(n >= array.length || pos < 0 || pos > n)
      {
         throw new Exception("Erro ao inserir!");
      }
 
      //levar elementos para o fim do array
      for(int i = n; i > pos; i--)
      {
         array[i] = array[i-1];
      }
 
      array[pos] = p;
      n++;
   }//fim inserir()

   public Presidente removerInicio() throws Exception 
   {
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
 
      Presidente resp = array[0];
      n--;
 
      for(int i = 0; i < n; i++)
      {
         array[i] = array[i+1];
      }
      //MyIO.println("(R) "+ resp.getNome());
      return resp;
   }// fim removerInicio()
 
   public Presidente removerFim() throws Exception 
   {
      //validar remocao
      if (n == 0) 
      {
         throw new Exception("Erro ao remover!");
      }
      Presidente resp = array[--n];
      //MyIO.println("(R) "+ resp.getNome());
      return resp;
   }//fim removerFim()
 
   public Presidente remover(int pos) throws Exception 
   {      
      //validar remocaosudo add-apt-repository ppa:webupd8team/sublime-text-3
      if (n == 0 || pos < 0 || pos >= n) 
      {
         throw new Exception("Erro ao remover!");
      }
 
      Presidente resp = array[pos];
 
      for(int i = pos; i < n; i++)
      {
         array[i] = array[i+1];
      }
      n--;//diminui tamanho do array
      
      //MyIO.println("(R) "+ resp.getNome());
      return resp;
   }// fim remover()
    /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar ()
   {
      for(int i = 0; i < n; i++){
         //System.out.print(array[i] + " ");
         MyIO.print("["+ i +"] ");
         array[i].imprimir();
      }
      
   }//fim mostrar()

   public boolean pesquisar(Presidente p)
   {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) 
      {
         retorno = (array[i] == p);
      }
      return retorno;
   }//fim pesquisar()
   
   public void mostrarRec ()
   {
      mostrarRec(0);
   }// fim mostrarRec()
 
   public void mostrarRec(int i)
   {
      if(i < n)
      {
         System.out.print(array[i] + " ");
         mostrarRec(i + 1);
      }
   }//mostrarRec()
 
}//fim class Lista

   public class Tp1p2Q02
   {
     public static void main (String [] args) throws Exception
     {  
       MyIO.setCharset("UTF-8");
       String arqTmp = MyIO.readLine(); //pega o direcionamento
       int i = 0;
       Lista lista  = new Lista();
             
       while(!arqTmp.equals("FIM") )
       {
          lista.inserirFim(Presidente.ler(arqTmp));
          arqTmp = MyIO.readLine();
          i++;  
       }
       
       int op = Integer.parseInt(MyIO.readLine()); // numero de operaçoes a serem feitas
       String entrada [] = new String [3];
       String buf = MyIO.readLine();   
       String removidos [] = new String [100];
       int k = 0;
      for(int j = 0; j < op; j++)
      {
        entrada  = buf.split(" ");          

        switch (entrada[0])
        {
           case "IF":
            lista.inserirFim(Presidente.ler(entrada[1]));
            break;
                     
           case "II":
            lista.inserirInicio(Presidente.ler(entrada[1]));
            break;
                     
           case "I*":
            lista.inserir(Integer.parseInt(entrada[1]), Presidente.ler(entrada[2]));
            break;
                     
            case "R*":
             
             Presidente p = lista.remover(Integer.parseInt(entrada[1]));;
             //MyIO.println("(R) "+p.getNome());
             removidos[k] = "(R) "+p.getNome();
             k++;
             break;
                     
            case "RF":
             Presidente p1 = lista.removerFim();
             //MyIO.println("(R) "+p1.getNome());
             removidos[k] = "(R) "+p1.getNome();
             k++;
             break;
                     
            case "RI":
             
             Presidente p2 = lista.removerInicio();
             removidos[k] = "(R) "+p2.getNome();
             k++;
             //MyIO.println( "(R) "+ p2.getNome());
             
             break;
                                                 
        }// fim switch

        buf = MyIO.readLine();

      } 
      //MyIO.println(">>>"+k);
        MyIO.setCharset("ISO-8859-1");

        for(int cont = 0;cont < k; cont++)
        {
          MyIO.println(""+removidos[cont]);
        }
        //MyIO.println(">>>>>>"+removidos[0]);

       lista.mostrar(); 
       	
    }// fim main()
   }//fim class Tp1p2Q02
