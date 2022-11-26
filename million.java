
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;



public class million extends JFrame{
    public static void main(String[] args) {
    
        million frame = new million();
        frame.initialize();
    }

    JLabel tittle,dbname,dbport,dbuser,userpasswd,question;
    JTextField name,port,user,uspasswd;
    JTextArea progress;
    JButton htp;
    JScrollPane scroll ;
    JPanel ptitle, pbody, pprogess;

    private Font title = new Font("Verdana", Font.BOLD, 30);
    private Font text = new Font("Monospaced", Font.CENTER_BASELINE,25);

  
    int s[] = new int[1000001];
    int p[] = new int[1000001];
    int error;

    private String Genid(String option){
        
        if (option == "S") {
            Random rand = new Random();
            int upperbound = 1000001;
            int int_random = rand.nextInt(upperbound); 
            String id;
            for (int i = 0; i < s.length+1; i++) {
                if(int_random != s[i]){
                    s[i] = int_random;
                    id = "s"+int_random;
                    return id;
                }
            }
            
        }if(option == "P"){
            
            Random rand = new Random();
            int upperbound = 1000001;
            int int_random = rand.nextInt(upperbound); 
            String id;
            for (int i = 0; i < p.length+1; i++) {
                if(int_random != p[i]){
                    p[i] = int_random;
                    id = "p"+int_random;
                    return id;
                }
            }
                        
        }
        return "";
    }
    private String Gname(){
        String name;
        String nombres[]={"Lela Stone","Cecelia Burns","Harry Gutierrez","Roosevelt Griffin","Ervin Dawson","Katrina Ryan","Inez Allison",
        "Jamie Robinson","Faye Guerrero","Edna Mendez","Cecil Richardson","Roberto Peters","Toby Schultz","Martin Young","Miriam Daniels",
        "Josefina Barrett","Frederick Cannon","Angel Gray","Dave Pratt","Dawn French","Lora Goodwin","Sidney Elliott","Ray Maxwell",
        "Leonard Schmidt","Miguel Lyons","Herbert Brock","Samuel Washington","Justin Hamilton","Blake Perez","Freddie Adkins",
        "Joyce Bush","Rick Alexander","Elbert Mclaughlin","Opal Summers","Shari Hunt","Tom Ray","Merle Moody","Monique Gomez",
        "Anna Cobb","Traci Stevenson","Audrey Barber","Sue Knight","Sean Mathis","Dixie Hicks","Eloise Stewart","Timothy Lloyd",
        "Marion Hughes","Stanley Estrada","Rosa Howell","Maria Ramsey"};
        Random rand = new Random();
        int upperbound = 50;
        int int_random = rand.nextInt(upperbound);
        name = nombres[int_random];
        return name;
    }

    private String Gciudad(){
        String city;
        String ciudades[]={"Vecaster","Xeafbert","Abrueyledo","Grupool","Phebridge","Godon","Qirie","Tando",
        "Elesgate","Inefield","Zligas","Niross","Eroifield","Zreledo","Glemouth","Plodon","Igling","Cladena",
        "Antaburg","Anbuland"};
        Random rand = new Random();
        int upperbound = 20;
        int int_random = rand.nextInt(upperbound);
        city = ciudades[int_random];
        return city;
    }

    private int Gestatus(){
        Random rand = new Random();
        int upperbound = 50;
        int int_random = rand.nextInt(upperbound); 
        int estado;
        estado = int_random;
        return estado;
    }

    private String Gepnombre(){
        String clothes;
        String pnombre[]={"Cravat","Tie","Shirt","Top","Lingerie","Robe","Cargos","Knickers","Tankini","Bra",
        "Cufflinks","Sunglasses","Briefs","Belt","Shawl","Camisole","T-Shirt","Kilt","Stockings","Scarf",
        "Coat","Suit","Pajamas","Underwear","Swimwear","Jogging Suit","Swimming Shorts","Tights","Corset",
        "Socks","Shoes","Jeans","Hat","Sweatshirt","Overalls","Fleece","Tracksuit","Bikini","Polo Shirt",
        "Shorts","Sandals","Gown","Skirt","Blouse","Nightgown","Cummerbund","Bow Tie","Blazer","Gloves","Boots"};
        Random rand = new Random();
        int upperbound = 50;
        int int_random = rand.nextInt(upperbound);
        clothes = pnombre[int_random];
        return clothes;
    }

    private String Gecolor(){
        String colores;
        String colors[]={"Red","Medium Slate Blue","Light Grey","Tan","White","Smoke","Aqua","Maroon","Lavender",
        "Blush","Peach Puff","Dark Violet","Indian Red","Papaya Whip"};
        Random rand = new Random();
        int upperbound = 13;
        int int_random = rand.nextInt(upperbound);
        colores = colors[int_random];
        return colores;
    }

    public int Geint(int num){
        Random rand = new Random();
        int upperbound = num;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }

    private void hackThePlanet(Statement st,Connection connection){
        error =0;

        try {
           
            // for para taba S
            for (int s = 0; s < Integer.parseInt(port.getText()); s++) {
                
                progress.append("se han insertado "+s+" tuplas\n");
                try {
                    String ids = Genid("S");
                    String idp = Genid("P"); 
                    st.executeUpdate("insert into S(snum,nombre,ciudad,estatus)values('"+ids+"','" +Gname()+ "','" +Gciudad()+ "'," +Gestatus()+ ");");
                    st.executeUpdate("insert into P(Pnum,nombre,color,peso)values('" +idp+ "','" +Gepnombre()+ "','" +Gecolor()+ "'," +Geint(201)+ ");");
                    st.executeUpdate("insert into SP(snum,pnum,cantidad)values('" +ids+ "','" +idp+ "'," +Geint(1001)+");");                    
                } catch (Exception e) {
                    // TODO: handle exception
                    //JOptionPane.showMessageDialog(null, e, "Error!", JOptionPane.ERROR_MESSAGE);
                    error ++;
                }
                
            }
            scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
            progress.append("\nAgregado correctamente\n ");
            
            progress.append("Errores: "+error);
            

            // note that i'm leaving "date_created" out of this insert statement
        
        JOptionPane.showMessageDialog(null, "Happy Hacking");
        
        connection.close();
        
        } catch (Exception exception) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, exception, "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(exception);
        }
    }

    public void initialize(){
        JFrame main = new JFrame();

        /*  title panel */
        tittle = new JLabel("MILLION",SwingConstants.CENTER);
        tittle.setFont(title);
        tittle.setForeground(Color.decode("#F4D03F"));

        ptitle = new JPanel();
        ptitle.setLayout(new BorderLayout());
        ptitle.setBackground(Color.black);
        ptitle.add(tittle,BorderLayout.NORTH);
        
        /*  body */
        dbname = new JLabel("DB Name",SwingConstants.CENTER);
        dbname.setFont(text);
        dbname.setForeground(Color.decode("#42FF33"));
        
        
        dbport = new JLabel("Numero de tuplas", SwingConstants.CENTER);
        dbport.setFont(text);
        dbport.setForeground(Color.decode("#42FF33"));
        
        dbuser = new JLabel("DB USER",SwingConstants.CENTER);
        dbuser.setFont(text);
        dbuser.setForeground(Color.decode("#42FF33"));

        userpasswd = new JLabel("Password",SwingConstants.CENTER);
        userpasswd.setFont(text);
        userpasswd.setForeground(Color.decode("#42FF33"));
       
        JPanel pname = new JPanel();
        pname.setBackground(Color.black);
        name = new JTextField(10);
        name.setFont(text);
        name.setBackground(Color.gray);
        name.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
        name.setForeground(Color.decode("#42FF33"));
        pname.add(name);

        JPanel jpport = new JPanel();
        jpport.setBackground(Color.black);
        port = new JTextField(10);
        port.setFont(text);
        port.setBackground(Color.gray);
        port.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
        port.setForeground(Color.decode("#42FF33"));
        jpport.add(port);

        JPanel puser = new JPanel();
        puser.setBackground(Color.black);
        user = new JTextField(10);
        user.setFont(text);
        user.setBackground(Color.gray);
        user.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
        user.setForeground(Color.decode("#42FF33"));
        puser.add(user);

        JPanel ppasword = new JPanel();
        ppasword.setBackground(Color.black);
        uspasswd = new JTextField(10);
        uspasswd.setFont(text);
        uspasswd.setBackground(Color.gray);
        uspasswd.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
        uspasswd.setForeground(Color.decode("#42FF33"));
        ppasword.add(uspasswd);

       
        progress = new JTextArea("Tu culo aqui");
        scroll = new JScrollPane(progress);
        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#42FF33")));
        progress.setEditable(false);
        progress.setBackground(Color.black);
        progress.setFont(text);
        progress.setForeground(Color.decode("#42FF33"));
        /* panel button */

        JPanel button = new JPanel();
        button.setBackground(Color.black);

        htp = new JButton(new ImageIcon("./img/btn.png"));
        htp.setFont(text);
        htp.setBorder( null );
        htp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Connection connection = null;
                progress.setText("Generando Tuplas...");
                try {
                    // below two lines are used for connectivity.
                    scroll.setBorder(BorderFactory.createLineBorder(Color.RED));
                    JOptionPane.showMessageDialog(null, "INICIANDO", "Hack the planet!", JOptionPane.INFORMATION_MESSAGE);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"+name.getText()+"",
                        ""+user.getText()+"", ""+uspasswd.getText()+"");
                        Statement st = connection.createStatement();
                        progress.setText("Connected Bitch!");
                        hackThePlanet(st, connection);
                        connection.close();
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception, "Error!", JOptionPane.ERROR_MESSAGE);
                    System.out.println(exception);
                }
            }
        });

        button.add(htp);

        pbody = new JPanel();
        pbody.setLayout(new GridLayout(0,1));
        //pbody.setLayout(new BoxLayout(pbody, BoxLayout.Y_AXIS));
        pbody.setAlignmentY(Component.CENTER_ALIGNMENT);
        pbody.setBackground(Color.black);

        
        pbody.add(dbname);
        pbody.add(pname);
        pbody.add(dbuser);
        pbody.add(puser);
        pbody.add(userpasswd);
        pbody.add(ppasword);
        pbody.add(dbport);
        pbody.add(jpport);
        pbody.add(button);
        pbody.add(scroll);
        
        
        /*  window settings */
        main.setLayout(new BorderLayout());
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(600, 1000);
        main.setVisible(true);

        main.add(ptitle,BorderLayout.NORTH);
        main.add(pbody,BorderLayout.CENTER);
        
        add(main);
    }

    
}
