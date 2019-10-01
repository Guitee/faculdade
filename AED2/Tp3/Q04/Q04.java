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
      // 15 de março de 1990  29dedezembrode1992

      //MyIO.println(">>"+linha);
      //linha = linha.replace("º","");
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
      //MyIO.println(">>>>"+dia); 
      //dia = dia.replace("º","");
      dia = tirarBolinha(dia);
      //MyIO.println(">>>>"+dia);
      data = LocalDate.of(Integer.parseInt(ano), numMes(mes), Integer.parseInt(dia));
      return data;
   }//fim arrumarData()

   public static String tirarBolinha (String l) // metodo para tirar º 
   {
      String resp = "";
      //MyIO.println(">>>>"+l.length());
       
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
      
      //MyIO.println(">>>"+linha);
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
     //15 de março de 1990a 29 de dezembro de 1992
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
      //31 de janeiro de 1956até 31 de janeiro de 1961
      else if(linha.charAt(i) == 'a' && linha.charAt(i+1) == 't' )
      {
         flag = i + 3;
         //MyIO.println(">>>>>>");
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
    //MyIO.println("FIM:"+fim);
    //MyIO.println("INICIO:"+inicio);
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
}//fim class Presidente

class No
{
  public boolean cor;
  public Presidente elemento;
  public No esq, dir;
  //construtor
  public No ()
  {
    this(null);
  }
  //construtor 1
  public No (Presidente elemento)
  {
      this(elemento, false, null, null);
  }
  // construtor 2 
  public No (Presidente elemento, boolean cor)
  {
    this(elemento, cor, null, null);
  }
  //construtor 3
  public No (Presidente elemento, boolean cor, No esq, No dir)
  {
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}// fim class No

class Alvinegra 
{
  private No raiz; // Raiz da arvore.
  public int comp;
    
  // Construtor da classe.
  public Alvinegra() 
  {
     raiz = null;
     this.comp = 0;
  }// fim construtor
  
  public int getComparacoes() 
   {
     return this.comp;
   }// fim getComparacoes()
 
   public void setComparacoes(int comp)
   {
     this.comp = comp;
   }// fim setComparacoes() 

    public boolean pesquisar(String elemento) 
    {
       MyIO.print(elemento + " "+ "raiz "); 
      return pesquisar(elemento, raiz);
    }// fim pesquisar
     
    private boolean pesquisar(String x, No i) 
    {
      boolean resp;
      if (i == null) 
      {
        resp = false;
      } else if (x.compareTo(i.elemento.getNome()) == 0) 
      {
         this.setComparacoes(this.getComparacoes()+1);
         resp = true;
 
      } else if (x.compareTo(i.elemento.getNome()) < 0) 
      {
         this.setComparacoes(this.getComparacoes()+1);
         MyIO.print("esq ");
         resp = pesquisar(x, i.esq);
 
      } else 
      {
         this.setComparacoes(this.getComparacoes()+1);
         MyIO.print("dir ");
         resp = pesquisar(x, i.dir);
      }
      return resp;
    }//fim pesquisar()
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarCentral() {
        System.out.print("[ ");
        mostrarCentral(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarCentral(No i) {
        if (i != null) {
            mostrarCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
            mostrarCentral(i.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPre() {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
            mostrarPre(i.esq); // Elementos da esquerda.
            mostrarPre(i.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPos() {
        System.out.print("[ ");
        mostrarPos(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarPos(No i) {
        if (i != null) {
            mostrarPos(i.esq); // Elementos da esquerda.
            mostrarPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
        }
    }

    public void inserir(Presidente p) throws Exception 
    {
      //Se a arvore estiver vazia
      if(raiz == null)
      {
        raiz = new No(p, false);
        //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");
 
      //Senao, se a arvore tiver um elemento 
      } else if (raiz.esq == null && raiz.dir == null)
      {
         if (raiz.elemento.getNome().compareTo( p.getNome()) > 0 )
         {
            raiz.esq = new No(p, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
         } else 
         {
            raiz.dir = new No(p, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
         }
 
      //Senao, se a arvore tiver dois elementos (raiz e dir)
      } else if (raiz.esq == null){
 
         if(raiz.elemento.getNome().compareTo(p.getNome()) > 0)
         {
            raiz.esq = new No(p);
            //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
 
         } else if (raiz.dir.elemento.getNome().compareTo( p.getNome() ) > 0)
         {
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = p;
            //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
 
         } else 
         {
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = raiz.dir.elemento;
            raiz.dir.elemento = p;
            //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }
 
         raiz.esq.cor = raiz.dir.cor = false;
          
      //Senao, se a arvore tiver dois elementos (raiz e esq)
      } else if (raiz.dir == null)
      {
          
        if(raiz.elemento.getNome().compareTo(p.getNome()) < 0)
        {
            raiz.dir = new No(p);
            //System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else if (raiz.esq.elemento.getNome().compareTo(p.getNome()) < 0)
         {
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = p;
            //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else 
         {
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = raiz.esq.elemento;
            raiz.esq.elemento = p;
            //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }
 
         raiz.esq.cor = raiz.dir.cor = false;
 
      //Senao, a arvore tem tres ou mais elementos
      } else 
      {
         //System.out.println("Arvore com tres ou mais elementos...");
           inserir(p, null, null, null, raiz);
      }
 
      raiz.cor = false;
   }//fim inserir() 
 
   private void balancear(No bisavo, No avo, No pai, No i)
   {
     //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
     if(pai.cor == true)
     {
      //4 tipos de reequilibrios e acoplamento
      if(pai.elemento.getNome().compareTo( avo.elemento.getNome()) > 0 )
      { // rotacao a esquerda ou direita-esquerda
        if(i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0 )
        {
          avo = rotacaoEsq(avo);
        }else 
        {
          avo = rotacaoDirEsq(avo);
        }
 
      }else 
      { // rotacao a direita ou esquerda-direita
        if(i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0)
        {
          avo = rotacaoDir(avo);
        }else 
        {
          avo = rotacaoEsqDir(avo);
        }
      }
 
      if (bisavo == null)
      {
        raiz = avo;
      }else 
      {
        if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0)
        {
          bisavo.esq = avo;
        } else 
        {
            bisavo.dir = avo;
        }
      }
       //reestabelecer as cores apos a rotacao
       avo.cor = false;
       avo.esq.cor = avo.dir.cor = true;
         //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
      } //if(pai.cor == true)
   }// fim balancear 
    
  private void inserir(Presidente p, No bisavo, No avo, No pai, No i) throws Exception 
  {
    if (i == null) 
    {
      if(p.getNome().compareTo(pai.elemento.getNome()) < 0 )
      {
        i = pai.esq = new No(p, true);
      }else 
      {
         i = pai.dir = new No(p, true);
      }
      if(pai.cor == true)
      {
        balancear(bisavo, avo, pai, i);
      }
     }else 
     {
      //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
       if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true)
       {
         i.cor = true;
         i.esq.cor = i.dir.cor = false;
         if(i == raiz)
         {
           i.cor = false;
         }else if(pai.cor == true)
         {
           balancear(bisavo, avo, pai, i);
         }
        }
        if (p.getNome().compareTo(i.elemento.getNome()) < 0) 
        {
            inserir(p, avo, pai, i, i.esq);
        } else if ( p.getNome().compareTo(i.elemento.getNome()) > 0) 
        {
          inserir(p, avo, pai, i, i.dir);
        } else 
        {
            throw new Exception("Erro inserir (elemento repetido)!");
        }
      }
    }// fim inserir
 
   private No rotacaoDir(No no) 
   {
      //System.out.println("Rotacao DIR(" + no.elemento + ")");
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;
 
      noEsq.dir = no;
      no.esq = noEsqDir;
 
      return noEsq;
   }// fim rotacaoDIr()
 
   private No rotacaoEsq(No no) 
   {
     // System.out.println("Rotacao ESQ(" + no.elemento + ")");
      No noDir = no.dir;
      No noDirEsq = noDir.esq;
 
      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }// fim rotacaoEsq
 
   private No rotacaoDirEsq(No no) 
   {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }//fim rotacaoDirEsq
 
   private No rotacaoEsqDir(No no) 
   {
     no.esq = rotacaoEsq(no.esq);
     return rotacaoDir(no);
   }// fim rotacaoEsqDir
}// fim class alvinegra

public class Q04
{
   public static void main (String [] args) throws Exception
     { 
       final long inicio = System.nanoTime(); //Comeca a contar o tempo de execucao 
       MyIO.setCharset("UTF-8");
       String arqTmp = MyIO.readLine(); //pega o direcionamento
       Alvinegra arvore = new Alvinegra();
              
       while(!arqTmp.contains("FIM") )
       {
       	  arvore.inserir(Presidente.ler(arqTmp));
          arqTmp = MyIO.readLine();
       }
       //MyIO.println(">>>");
       boolean resp;
       //MyIO.setCharset("ISO-8859-1");
       arqTmp = MyIO.readLine();
       //MyIO.println(">>>"+ arqTmp);
       while(!arqTmp.contains("FIM") )
       {
          resp = arvore.pesquisar(arqTmp);
          if(resp == false)
          {
          	MyIO.println("N"+ (char)195 +"O");
          }
          else
          {
          	MyIO.println("SIM" );
          }
        
          arqTmp = MyIO.readLine();
       } 
           
     final long tempoFinal = (System.nanoTime() - inicio) /1000000000; //termina de pegar o tempo e resulta no tempo final  
     try
     {
        FileWriter matri = new FileWriter("matrícula_arvoreAvinegra.txt");
        PrintWriter print = new PrintWriter(matri);
        print.println("553364\t" + tempoFinal + "\t" + arvore.getComparacoes()); 
        matri.close(); 
    }//fim try
    catch(IOException e1)
    {
       e1.printStackTrace();
    }

   }// fim main()	

}//fim class Q04

/*
 RESULTADOS
 *Tempo final = 0
 *Comparacoes = 696
  */