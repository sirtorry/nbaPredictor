import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class nbaGui extends JFrame
{
    private JLabel homeLabel;
    private JLabel awayLabel;
    private JLabel blank1;
    private JLabel blank2;
    private JLabel homeLogo;
    private JLabel awayLogo;
    private JLabel homeResult;
    private JLabel awayResult;
    private JButton predict;
    private ImageIcon homeImage;
    private ImageIcon awayImage;

    JMenuBar menubar;
    JMenu home;
    JMenu away;
    
    JMenuItem homeATL;
    JMenuItem homeBOS;
    JMenuItem homeBRK;
    JMenuItem homeCHA;
    JMenuItem homeCHI;
    JMenuItem homeCLE;
    JMenuItem homeDAL;
    JMenuItem homeDEN;
    JMenuItem homeDET;
    JMenuItem homeGSW;
    JMenuItem homeHOU;
    JMenuItem homeIND;
    JMenuItem homeLAC;
    JMenuItem homeLAL;
    JMenuItem homeMEM;
    JMenuItem homeMIA;
    JMenuItem homeMIL;
    JMenuItem homeMIN;
    JMenuItem homeNOH;
    JMenuItem homeNYK;
    JMenuItem homeOKC;
    JMenuItem homeORL;
    JMenuItem homePHI;
    JMenuItem homePHO;
    JMenuItem homePOR;
    JMenuItem homeSAC;
    JMenuItem homeSAS;
    JMenuItem homeTOR;
    JMenuItem homeUTA;
    JMenuItem homeWAS;
    
    JMenuItem awayATL;
    JMenuItem awayBOS;
    JMenuItem awayBRK;
    JMenuItem awayCHA;
    JMenuItem awayCHI;
    JMenuItem awayCLE;
    JMenuItem awayDAL;
    JMenuItem awayDEN;
    JMenuItem awayDET;
    JMenuItem awayGSW;
    JMenuItem awayHOU;
    JMenuItem awayIND;
    JMenuItem awayLAC;
    JMenuItem awayLAL;
    JMenuItem awayMEM;
    JMenuItem awayMIA;
    JMenuItem awayMIL;
    JMenuItem awayMIN;
    JMenuItem awayNOH;
    JMenuItem awayNYK;
    JMenuItem awayOKC;
    JMenuItem awayORL;
    JMenuItem awayPHI;
    JMenuItem awayPHO;
    JMenuItem awayPOR;
    JMenuItem awaySAC;
    JMenuItem awaySAS;
    JMenuItem awayTOR;
    JMenuItem awayUTA;
    JMenuItem awayWAS;
    
    predictor nn = new predictor();
    
    public nbaGui()
    {
        setLayout(new GridLayout(3,2));
        
        homeLabel = new JLabel("Home Team",JLabel.CENTER);
        homeLabel.setHorizontalTextPosition(JLabel.CENTER);
        awayLabel = new JLabel("Away Team",JLabel.CENTER);
        awayLabel.setHorizontalTextPosition(JLabel.CENTER);
        homeResult = new JLabel("N/A",JLabel.CENTER);
        homeResult.setHorizontalTextPosition(JLabel.CENTER);
        awayResult = new JLabel("N/A",JLabel.CENTER);
        awayResult.setHorizontalTextPosition(JLabel.CENTER);
        
        homeImage = new ImageIcon(getClass().getResource("None.gif"));
        homeLogo = new JLabel(homeImage);
        awayImage = new ImageIcon(getClass().getResource("None.gif"));
        awayLogo = new JLabel(awayImage);
        
        predict = new JButton("Predict");
        
        add(homeLabel);
        add(awayLabel);
        add(homeLogo);
        add(awayLogo);
        add(homeResult);
        add(awayResult);
        
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        home = new JMenu("Home");
        menubar.add(home);
        away = new JMenu("Away");
        menubar.add(away);
        
        homeATL = new JMenuItem("ATL");
        home.add(homeATL);
        homeBOS = new JMenuItem("BOS");
        home.add(homeBOS);
        homeBRK = new JMenuItem("BRK");
        home.add(homeBRK);
        homeCHA = new JMenuItem("CHA");
        home.add(homeCHA);
        homeCHI = new JMenuItem("CHI");
        home.add(homeCHI);
        homeCLE = new JMenuItem("CLE");
        home.add(homeCLE);
        homeDAL = new JMenuItem("DAL");
        home.add(homeDAL);
        homeDEN = new JMenuItem("DEN");
        home.add(homeDEN);
        homeDET = new JMenuItem("DET");
        home.add(homeDET);
        homeGSW = new JMenuItem("GSW");
        home.add(homeGSW);
        homeHOU = new JMenuItem("HOU");
        home.add(homeHOU);
        homeIND = new JMenuItem("IND");
        home.add(homeIND);
        homeLAC = new JMenuItem("LAC");
        home.add(homeLAC);
        homeLAL = new JMenuItem("LAL");
        home.add(homeLAL);
        homeMEM = new JMenuItem("MEM");
        home.add(homeMEM);
        homeMIA = new JMenuItem("MIA");
        home.add(homeMIA);
        homeMIL = new JMenuItem("MIL");
        home.add(homeMIL);
        homeMIN = new JMenuItem("MIN");
        home.add(homeMIN);
        homeNOH = new JMenuItem("NOH");
        home.add(homeNOH);
        homeNYK = new JMenuItem("NYK");
        home.add(homeNYK);
        homeOKC = new JMenuItem("OKC");
        home.add(homeOKC);
        homeORL = new JMenuItem("ORL");
        home.add(homeORL);
        homePHI = new JMenuItem("PHI");
        home.add(homePHI);
        homePHO = new JMenuItem("PHO");
        home.add(homePHO);
        homePOR = new JMenuItem("POR");
        home.add(homePOR);
        homeSAC = new JMenuItem("SAC");
        home.add(homeSAC);
        homeSAS = new JMenuItem("SAS");
        home.add(homeSAS);
        homeTOR = new JMenuItem("TOR");
        home.add(homeTOR);
        homeUTA = new JMenuItem("UTA");
        home.add(homeUTA);
        homeWAS = new JMenuItem("WAS");
        home.add(homeWAS);
        awayATL = new JMenuItem("ATL");
        away.add(awayATL);
        awayBOS = new JMenuItem("BOS");
        away.add(awayBOS);
        awayBRK = new JMenuItem("BRK");
        away.add(awayBRK);
        awayCHA = new JMenuItem("CHA");
        away.add(awayCHA);
        awayCHI = new JMenuItem("CHI");
        away.add(awayCHI);
        awayCLE = new JMenuItem("CLE");
        away.add(awayCLE);
        awayDAL = new JMenuItem("DAL");
        away.add(awayDAL);
        awayDEN = new JMenuItem("DEN");
        away.add(awayDEN);
        awayDET = new JMenuItem("DET");
        away.add(awayDET);
        awayGSW = new JMenuItem("GSW");
        away.add(awayGSW);
        awayHOU = new JMenuItem("HOU");
        away.add(awayHOU);
        awayIND = new JMenuItem("IND");
        away.add(awayIND);
        awayLAC = new JMenuItem("LAC");
        away.add(awayLAC);
        awayLAL = new JMenuItem("LAL");
        away.add(awayLAL);
        awayMEM = new JMenuItem("MEM");
        away.add(awayMEM);
        awayMIA = new JMenuItem("MIA");
        away.add(awayMIA);
        awayMIL = new JMenuItem("MIL");
        away.add(awayMIL);
        awayMIN = new JMenuItem("MIN");
        away.add(awayMIN);
        awayNOH = new JMenuItem("NOH");
        away.add(awayNOH);
        awayNYK = new JMenuItem("NYK");
        away.add(awayNYK);
        awayOKC = new JMenuItem("OKC");
        away.add(awayOKC);
        awayORL = new JMenuItem("ORL");
        away.add(awayORL);
        awayPHI = new JMenuItem("PHI");
        away.add(awayPHI);
        awayPHO = new JMenuItem("PHO");
        away.add(awayPHO);
        awayPOR = new JMenuItem("POR");
        away.add(awayPOR);
        awaySAC = new JMenuItem("SAC");
        away.add(awaySAC);
        awaySAS = new JMenuItem("SAS");
        away.add(awaySAS);
        awayTOR = new JMenuItem("TOR");
        away.add(awayTOR);
        awayUTA = new JMenuItem("UTA");
        away.add(awayUTA);
        awayWAS = new JMenuItem("WAS");
        away.add(awayWAS);
        
		event1 eventHomeATL = new event1();
        homeATL.addActionListener(eventHomeATL);
		event2 eventHomeBOS = new event2();
        homeBOS.addActionListener(eventHomeBOS);
		event3 eventHomeBRK = new event3();
        homeBRK.addActionListener(eventHomeBRK);
		event4 eventHomeCHA = new event4();
        homeCHA.addActionListener(eventHomeCHA);
		event5 eventHomeCHI = new event5();
        homeCHI.addActionListener(eventHomeCHI);
		event6 eventHomeCLE = new event6();
        homeCLE.addActionListener(eventHomeCLE);
		event7 eventHomeDAL = new event7();
        homeDAL.addActionListener(eventHomeDAL);
		event8 eventHomeDEN = new event8();
        homeDEN.addActionListener(eventHomeDEN);
		event9 eventHomeDET = new event9();
        homeDET.addActionListener(eventHomeDET);
		event10 eventHomeGSW = new event10();
        homeGSW.addActionListener(eventHomeGSW);
		event11 eventHomeHOU = new event11();
        homeHOU.addActionListener(eventHomeHOU);
		event12 eventHomeIND = new event12();
        homeIND.addActionListener(eventHomeIND);
		event13 eventHomeLAC = new event13();
        homeLAC.addActionListener(eventHomeLAC);
		event14 eventHomeLAL = new event14();
        homeLAL.addActionListener(eventHomeLAL);
		event15 eventHomeMEM = new event15();
        homeMEM.addActionListener(eventHomeMEM);
		event16 eventHomeMIA = new event16();
        homeMIA.addActionListener(eventHomeMIA);
		event17 eventHomeMIL = new event17();
        homeMIL.addActionListener(eventHomeMIL);
		event18 eventHomeMIN = new event18();
        homeMIN.addActionListener(eventHomeMIN);
		event19 eventHomeNOH = new event19();
        homeNOH.addActionListener(eventHomeNOH);
		event20 eventHomeNYK = new event20();
        homeNYK.addActionListener(eventHomeNYK);
		event21 eventHomeOKC = new event21();
        homeOKC.addActionListener(eventHomeOKC);
		event22 eventHomeORL = new event22();
        homeORL.addActionListener(eventHomeORL);
		event23 eventHomePHI = new event23();
        homePHI.addActionListener(eventHomePHI);
		event24 eventHomePHO = new event24();
        homePHO.addActionListener(eventHomePHO);
		event25 eventHomePOR = new event25();
        homePOR.addActionListener(eventHomePOR);
		event26 eventHomeSAC = new event26();
        homeSAC.addActionListener(eventHomeSAC);
		event27 eventHomeSAS = new event27();
        homeSAS.addActionListener(eventHomeSAS);
		event28 eventHomeTOR = new event28();
        homeTOR.addActionListener(eventHomeTOR);
		event29 eventHomeUTA = new event29();
        homeUTA.addActionListener(eventHomeUTA);
		event30 eventHomeWAS = new event30();
        homeWAS.addActionListener(eventHomeWAS);
        
		e1 eventAwayATL = new e1();
        awayATL.addActionListener(eventAwayATL);
		e2 eventAwayBOS = new e2();
        awayBOS.addActionListener(eventAwayBOS);
		e3 eventAwayBRK = new e3();
        awayBRK.addActionListener(eventAwayBRK);
		e4 eventAwayCHA = new e4();
        awayCHA.addActionListener(eventAwayCHA);
		e5 eventAwayCHI = new e5();
        awayCHI.addActionListener(eventAwayCHI);
		e6 eventAwayCLE = new e6();
        awayCLE.addActionListener(eventAwayCLE);
		e7 eventAwayDAL = new e7();
        awayDAL.addActionListener(eventAwayDAL);
		e8 eventAwayDEN = new e8();
        awayDEN.addActionListener(eventAwayDEN);
		e9 eventAwayDET = new e9();
        awayDET.addActionListener(eventAwayDET);
		e10 eventAwayGSW = new e10();
        awayGSW.addActionListener(eventAwayGSW);
		e11 eventAwayHOU = new e11();
        awayHOU.addActionListener(eventAwayHOU);
		e12 eventAwayIND = new e12();
        awayIND.addActionListener(eventAwayIND);
		e13 eventAwayLAC = new e13();
        awayLAC.addActionListener(eventAwayLAC);
		e14 eventAwayLAL = new e14();
        awayLAL.addActionListener(eventAwayLAL);
		e15 eventAwayMEM = new e15();
        awayMEM.addActionListener(eventAwayMEM);
		e16 eventAwayMIA = new e16();
        awayMIA.addActionListener(eventAwayMIA);
		e17 eventAwayMIL = new e17();
        awayMIL.addActionListener(eventAwayMIL);
		e18 eventAwayMIN = new e18();
        awayMIN.addActionListener(eventAwayMIN);
		e19 eventAwayNOH = new e19();
        awayNOH.addActionListener(eventAwayNOH);
		e20 eventAwayNYK = new e20();
        awayNYK.addActionListener(eventAwayNYK);
		e21 eventAwayOKC = new e21();
        awayOKC.addActionListener(eventAwayOKC);
		e22 eventAwayORL = new e22();
        awayORL.addActionListener(eventAwayORL);
		e23 eventAwayPHI = new e23();
        awayPHI.addActionListener(eventAwayPHI);
		e24 eventAwayPHO = new e24();
        awayPHO.addActionListener(eventAwayPHO);
		e25 eventAwayPOR = new e25();
        awayPOR.addActionListener(eventAwayPOR);
		e26 eventAwaySAC = new e26();
        awaySAC.addActionListener(eventAwaySAC);
		e27 eventAwaySAS = new e27();
        awaySAS.addActionListener(eventAwaySAS);
		e28 eventAwayTOR = new e28();
        awayTOR.addActionListener(eventAwayTOR);
		e29 eventAwayUTA = new e29();
        awayUTA.addActionListener(eventAwayUTA);
		e30 eventAwayWAS = new e30();
        awayWAS.addActionListener(eventAwayWAS);
        
        event press = new event();
        predict.addActionListener(press);
    }
    
    public class event implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeATL)
        {
            nn.predict();
            if(nn.getResult())
            {
                homeResult.setText("Win");
                awayResult.setText("Lose");
            }
            else
            {
                homeResult.setText("Lose");
                awayResult.setText("Win");
            }
        }

    }
    
    public void update()
    {
        if(nn.ready())
        {
            nn.predict();
            if(nn.getResult())
            {
                homeResult.setText("Win");
                awayResult.setText("Lose");
            }
            else
            {
                homeResult.setText("Lose");
                awayResult.setText("Win");
            }
        }
    }
        
    public  class event1 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeATL)
        {
            nn.setHomeATL();
            homeImage = new ImageIcon(getClass().getResource("ATL.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event2 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeBOS)
        {
            nn.setHomeBOS();
            homeImage = new ImageIcon(getClass().getResource("BOS.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event3 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeBRK)
        {
            nn.setHomeBRK();
            homeImage = new ImageIcon(getClass().getResource("BRK.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event4 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeCHA)
        {
            nn.setHomeCHA();
            homeImage = new ImageIcon(getClass().getResource("CHA.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event5 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeCHI)
        {
            nn.setHomeCHI();
            homeImage = new ImageIcon(getClass().getResource("CHI.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event6 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeCLE)
        {
            nn.setHomeCLE();
            homeImage = new ImageIcon(getClass().getResource("CLE.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event7 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeDAL)
        {
            nn.setHomeDAL();
            homeImage = new ImageIcon(getClass().getResource("DAL.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event8 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeDEN)
        {
            nn.setHomeDEN();
            homeImage = new ImageIcon(getClass().getResource("DEN.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event9 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeDET)
        {
            nn.setHomeDET();
            homeImage = new ImageIcon(getClass().getResource("DET.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event10 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeGSW)
        {
            nn.setHomeGSW();
            homeImage = new ImageIcon(getClass().getResource("GSW.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event11 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeHOU)
        {
            nn.setHomeHOU();
            homeImage = new ImageIcon(getClass().getResource("HOU.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event12 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeIND)
        {
            nn.setHomeIND();
            homeImage = new ImageIcon(getClass().getResource("IND.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event13 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeLAC)
        {
            nn.setHomeLAC();
            homeImage = new ImageIcon(getClass().getResource("LAC.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event14 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeLAL)
        {
            nn.setHomeLAL();
            homeImage = new ImageIcon(getClass().getResource("LAL.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event15 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeMEM)
        {
            nn.setHomeMEM();
            homeImage = new ImageIcon(getClass().getResource("MEM.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event16 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeMIA)
        {
            nn.setHomeMIA();
            homeImage = new ImageIcon(getClass().getResource("MIA.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event17 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeMIL)
        {
            nn.setHomeMIL();
            homeImage = new ImageIcon(getClass().getResource("MIL.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event18 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeMIN)
        {
            nn.setHomeMIN();
            homeImage = new ImageIcon(getClass().getResource("MIN.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event19 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeNOH)
        {
            nn.setHomeNOH();
            homeImage = new ImageIcon(getClass().getResource("NOH.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event20 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeNYK)
        {
            nn.setHomeNYK();
            homeImage = new ImageIcon(getClass().getResource("NYK.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event21 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeOKC)
        {
            nn.setHomeOKC();
            homeImage = new ImageIcon(getClass().getResource("OKC.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event22 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeORL)
        {
            nn.setHomeORL();
            homeImage = new ImageIcon(getClass().getResource("ORL.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event23 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomePHI)
        {
            nn.setHomePHI();
            homeImage = new ImageIcon(getClass().getResource("PHI.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event24 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomePHO)
        {
            nn.setHomePHO();
            homeImage = new ImageIcon(getClass().getResource("PHO.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event25 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomePOR)
        {
            nn.setHomePOR();
            homeImage = new ImageIcon(getClass().getResource("POR.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event26 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeSAC)
        {
            nn.setHomeSAC();
            homeImage = new ImageIcon(getClass().getResource("SAC.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event27 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeSAS)
        {
            nn.setHomeSAS();
            homeImage = new ImageIcon(getClass().getResource("SAS.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event28 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeTOR)
        {
            nn.setHomeTOR();
            homeImage = new ImageIcon(getClass().getResource("TOR.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event29 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeUTA)
        {
            nn.setHomeUTA();
            homeImage = new ImageIcon(getClass().getResource("UTA.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
	public  class event30 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventHomeWAS)
        {
            nn.setHomeWAS();
            homeImage = new ImageIcon(getClass().getResource("WAS.gif"));
            homeLogo.setIcon(homeImage);
            update();
        }
    }
    
    public  class e1 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayATL)
        {
            nn.setAwayATL();
            awayImage = new ImageIcon(getClass().getResource("ATL.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e2 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayBOS)
        {
            nn.setAwayBOS();
            awayImage = new ImageIcon(getClass().getResource("BOS.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e3 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayBRK)
        {
            nn.setAwayBRK();
            awayImage = new ImageIcon(getClass().getResource("BRK.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e4 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayCHA)
        {
            nn.setAwayCHA();
            awayImage = new ImageIcon(getClass().getResource("CHA.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e5 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayCHI)
        {
            nn.setAwayCHI();
            awayImage = new ImageIcon(getClass().getResource("CHI.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e6 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayCLE)
        {
            nn.setAwayCLE();
            awayImage = new ImageIcon(getClass().getResource("CLE.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e7 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayDAL)
        {
            nn.setAwayDAL();
            awayImage = new ImageIcon(getClass().getResource("DAL.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e8 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayDEN)
        {
            nn.setAwayDEN();
            awayImage = new ImageIcon(getClass().getResource("DEN.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e9 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayDET)
        {
            nn.setAwayDET();
            awayImage = new ImageIcon(getClass().getResource("DET.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e10 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayGSW)
        {
            nn.setAwayGSW();
            awayImage = new ImageIcon(getClass().getResource("GSW.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e11 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayHOU)
        {
            nn.setAwayHOU();
            awayImage = new ImageIcon(getClass().getResource("HOU.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e12 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayIND)
        {
            nn.setAwayIND();
            awayImage = new ImageIcon(getClass().getResource("IND.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e13 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayLAC)
        {
            nn.setAwayLAC();
            awayImage = new ImageIcon(getClass().getResource("LAC.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e14 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayLAL)
        {
            nn.setAwayLAL();
            awayImage = new ImageIcon(getClass().getResource("LAL.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e15 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayMEM)
        {
            nn.setAwayMEM();
            awayImage = new ImageIcon(getClass().getResource("MEM.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e16 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayMIA)
        {
            nn.setAwayMIA();
            awayImage = new ImageIcon(getClass().getResource("MIA.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e17 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayMIL)
        {
            nn.setAwayMIL();
            awayImage = new ImageIcon(getClass().getResource("MIL.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e18 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayMIN)
        {
            nn.setAwayMIN();
            awayImage = new ImageIcon(getClass().getResource("MIN.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e19 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayNOH)
        {
            nn.setAwayNOH();
            awayImage = new ImageIcon(getClass().getResource("NOH.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e20 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayNYK)
        {
            nn.setAwayNYK();
            awayImage = new ImageIcon(getClass().getResource("NYK.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e21 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayOKC)
        {
            nn.setAwayOKC();
            awayImage = new ImageIcon(getClass().getResource("OKC.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e22 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayORL)
        {
            nn.setAwayORL();
            awayImage = new ImageIcon(getClass().getResource("ORL.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e23 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayPHI)
        {
            nn.setAwayPHI();
            awayImage = new ImageIcon(getClass().getResource("PHI.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e24 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayPHO)
        {
            nn.setAwayPHO();
            awayImage = new ImageIcon(getClass().getResource("PHO.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e25 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayPOR)
        {
            nn.setAwayPOR();
            awayImage = new ImageIcon(getClass().getResource("POR.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e26 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwaySAC)
        {
            nn.setAwaySAC();
            awayImage = new ImageIcon(getClass().getResource("SAC.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e27 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwaySAS)
        {
            nn.setAwaySAS();
            awayImage = new ImageIcon(getClass().getResource("SAS.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e28 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayTOR)
        {
            nn.setAwayTOR();
            awayImage = new ImageIcon(getClass().getResource("TOR.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e29 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayUTA)
        {
            nn.setAwayUTA();
            awayImage = new ImageIcon(getClass().getResource("UTA.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
	public  class e30 implements ActionListener
    {
        public void actionPerformed(ActionEvent eventAwayWAS)
        {
            nn.setAwayWAS();
            awayImage = new ImageIcon(getClass().getResource("WAS.gif"));
            awayLogo.setIcon(awayImage);
            update();
        }
    }
}
