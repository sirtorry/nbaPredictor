import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.util.TransferFunctionType;
import org.neuroph.nnet.learning.BackPropagation;
import java.util.ArrayList;

public class predictor
{    
    double[] ATL = {0.39230769230769186, 0.4452554744525547, 0.694736842105263, 0.28571428571428564, 0.7878787878787877, 0.1739130434782608, 0.6075949367088604, 0.10526315789473667, 0.6086956521739132, 0.384615384615385, 0.3529411764705878, 0.4967320261437906};
    double[] BOS = {0.23846153846153803, 0.30656934306569283, 0.4736842105263155, 0.4805194805194807, 0.6060606060606057, 0.0, 0.4177215189873414, 0.6140350877192979, 0.6521739130434785, 0.461538461538462, 0.24264705882352905, 0.42483660130718964};
    double[] BRK = {0.5230769230769229, 0.5839416058394166, 0.421052631578947, 0.6818181818181819, 0.818181818181818, 0.8956521739130434, 0.721518987341772, 0.04385964912280705, 0.34782608695652156, 0.36538461538461575, 0.22794117647058873, 0.33333333333333304};
    double[] CHA = {0.015384615384615604, 1.0, 0.0, 0.7857142857142858, 0.3636363636363631, 0.4695652173913043, 1.0, 0.3859649122807018, 0.45652173913043476, 1.0, 0.02205882352941154, 0.8758169934640528};
    double[] CHI = {0.19230769230769232, 0.3138686131386862, 0.1263157894736843, 0.42857142857142866, 0.7272727272727271, 0.8608695652173912, 0.3417721518987337, 0.4035087719298246, 0.4347826086956521, 0.5576923076923083, 0.0, 0.18300653594771227};
    double[] CLE = {0.30000000000000043, 0.8540145985401458, 0.22105263157894692, 0.5194805194805197, 0.42424242424242375, 0.7217391304347823, 0.9873417721518988, 0.6754385964912278, 0.739130434782609, 0.7115384615384623, 0.3235294117647061, 0.7843137254901962};
    double[] DAL = {0.4769230769230771, 0.6350364963503646, 0.5473684210526313, 0.3831168831168832, 0.3636363636363631, 0.13043478260869554, 0.6075949367088604, 0.7105263157894735, 0.41304347826086946, 0.34615384615384653, 0.6544117647058824, 0.8366013071895424};
    double[] DEN = {0.7615384615384619, 0.47445255474452597, 0.6421052631578945, 0.7272727272727273, 0.6666666666666664, 0.9739130434782608, 0.5949367088607592, 0.37719298245614036, 0.6521739130434785, 0.6538461538461545, 0.9632352941176471, 0.7516339869281047};
    double[] DET = {0.2076923076923079, 0.7518248175182486, 0.30526315789473646, 0.5649350649350652, 0.818181818181818, 0.6956521739130432, 0.7088607594936707, 0.43859649122807026, 0.3260869565217389, 0.5576923076923083, 0.10294117647058859, 0.6078431372549019};
    double[] GSW = {0.4692307692307688, 0.5182481751824818, 0.5157894736842102, 0.4480519480519482, 0.7575757575757573, 0.4521739130434782, 0.4810126582278477, 0.5175438596491224, 0.1739130434782611, 0.1153846153846155, 0.5661764705882352, 0.6928104575163396};
    double[] HOU = {0.7384615384615381, 0.6058394160583944, 0.7789473684210525, 0.7532467532467534, 1.0, 0.5130434782608696, 0.772151898734177, 0.22807017543859642, 0.47826086956521735, 0.0, 1.0, 0.8627450980392161};
    double[] IND = {0.2923076923076921, 0.0, 0.2421052631578943, 0.5974025974025974, 0.8484848484848484, 0.8608695652173912, 0.0, 0.3157894736842105, 0.30434782608695626, 0.17307692307692327, 0.11764705882352997, 0.0};
    double[] LAC = {0.7230769230769235, 0.3649635036496353, 0.726315789473684, 0.6428571428571428, 0.7575757575757573, 0.7478260869565215, 0.5696202531645567, 0.7105263157894735, 1.0, 0.4423076923076928, 0.5882352941176467, 0.30718954248366037};
    double[] LAL = {0.5999999999999998, 0.5839416058394166, 0.6210526315789472, 0.9350649350649354, 0.6969696969696967, 0.5739130434782609, 0.632911392405063, 0.0, 0.10869565217391318, 0.2692307692307695, 0.683823529411764, 0.7581699346405226};
    double[] MEM = {0.2923076923076921, 0.15328467153284642, 0.17894736842105216, 0.4025974025974027, 0.6666666666666664, 1.0, 0.39240506329113883, 0.43859649122807026, 0.8695652173913048, 0.30769230769230804, 0.051470588235294296, 0.0};
    double[] MIA = {1.0, 0.3868613138686133, 1.0, 0.6753246753246753, 0.3636363636363631, 0.18260869565217386, 0.5189873417721516, 0.35964912280701755, 0.7826086956521743, 0.5576923076923083, 0.7794117647058825, 0.3921568627450981};
    double[] MIL = {0.2538461538461536, 0.5036496350364962, 0.22105263157894692, 0.33116883116883117, 0.33333333333333276, 0.6695652173913045, 0.5696202531645567, 0.37719298245614036, 0.7173913043478264, 0.8653846153846152, 0.43382352941176483, 0.6993464052287585};
    double[] MIN = {0.14615384615384658, 0.547445255474453, 0.14736842105263168, 0.7467532467532468, 0.7575757575757573, 0.6956521739130432, 0.772151898734177, 0.219298245614035, 0.739130434782609, 0.4230769230769235, 0.1470588235294117, 0.5424836601307189};
    double[] NOH = {0.38461538461538464, 0.8613138686131392, 0.38947368421052597, 0.3051948051948052, 0.7272727272727271, 0.7217391304347823, 0.8860759493670886, 0.4649122807017545, 0.34782608695652156, 0.34615384615384653, 0.08088235294117704, 0.5228758169934642};
    double[] NYK = {0.7692307692307693, 0.5620437956204376, 0.5684210526315787, 0.4805194805194807, 0.0, 0.4695652173913043, 0.772151898734177, 0.4649122807017545, 0.7173913043478264, 0.17307692307692327, 0.4558823529411764, 0.4117647058823528};
    double[] OKC = {0.9615384615384616, 0.2773722627737227, 0.7684210526315788, 1.0, 0.8787878787878787, 0.5565217391304348, 0.31645569620253117, 0.27192982456140347, 0.5434782608695653, 0.4230769230769235, 0.9852941176470587, 0.49019607843137264};
    double[] ORL = {0.13846153846153825, 0.8248175182481756, 0.3684210526315786, 0.0, 0.636363636363636, 0.417391304347826, 0.7848101265822783, 0.35964912280701755, 0.0, 0.15384615384615402, 0.10294117647058859, 0.7450980392156867};
    double[] PHI = {0.12307692307692264, 0.5547445255474454, 0.29473684210526274, 0.038961038961039, 0.2424242424242418, 0.39130434782608686, 0.632911392405063, 0.3947368421052632, 0.5217391304347826, 0.32692307692307726, 0.0, 0.45751633986928114};
    double[] PHO = {0.015384615384615604, 0.6934306569343072, 0.19999999999999954, 0.27922077922077915, 0.818181818181818, 0.6000000000000001, 0.8101265822784809, 0.44736842105263164, 0.6521739130434785, 0.6153846153846161, 0.11764705882352997, 0.7254901960784311};
    double[] POR = {0.46153846153846156, 0.737226277372263, 0.48421052631578915, 0.3766233766233767, 0.6666666666666664, 0.5130434782608696, 0.7594936708860758, 0.18421052631578935, 0.21739130434782636, 0.4038461538461543, 0.3970588235294119, 0.6535947712418302};
    double[] SAC = {0.40000000000000024, 0.9489051094890519, 0.38947368421052597, 0.5194805194805197, 0.5757575757575754, 0.5391304347826087, 0.8860759493670886, 0.6052631578947365, 0.5217391304347826, 0.9615384615384615, 0.5073529411764707, 1.0};
    double[] SAS = {0.7384615384615381, 0.23357664233576578, 0.8842105263157894, 0.4675324675324677, 0.5454545454545451, 0.01739130434782586, 0.39240506329113883, 0.12280701754385949, 0.5434782608695653, 0.21153846153846176, 0.8455882352941171, 0.4509803921568632};
    double[] TOR = {0.4153846153846158, 0.7007299270072994, 0.3368421052631575, 0.5129870129870132, 0.33333333333333276, 0.49565217391304345, 0.7088607594936707, 1.0, 0.5434782608695653, 0.5192307692307698, 0.33088235294117624, 0.6470588235294122};
    double[] UTA = {0.4153846153846158, 0.6569343065693436, 0.3368421052631575, 0.6493506493506493, 0.7575757575757573, 0.7999999999999998, 0.6962025316455694, 0.6666666666666664, 0.5652173913043479, 0.5576923076923083, 0.3750000000000004, 0.6143790849673207};
    double[] WAS = {0.0, 0.3357664233576641, 0.2421052631578943, 0.37012987012987014, 0.8484848484848484, 0.37391304347826076, 0.4303797468354426, 0.4736842105263159, 0.5, 0.230769230769231, 0.007352941176471211, 0.3790849673202613};
    
    NeuralNetwork nn1 = NeuralNetwork.load("ATL.nnet");
    NeuralNetwork nn2 = NeuralNetwork.load("BOS.nnet");
    NeuralNetwork nn3 = NeuralNetwork.load("BRK.nnet");
    NeuralNetwork nn4 = NeuralNetwork.load("CHA.nnet");
    NeuralNetwork nn5 = NeuralNetwork.load("CHI.nnet");
    NeuralNetwork nn6 = NeuralNetwork.load("CLE.nnet");
    NeuralNetwork nn7 = NeuralNetwork.load("DAL.nnet");
    NeuralNetwork nn8 = NeuralNetwork.load("DEN.nnet");
    NeuralNetwork nn9 = NeuralNetwork.load("DET.nnet");
    NeuralNetwork nn10 = NeuralNetwork.load("GSW.nnet");
    NeuralNetwork nn11 = NeuralNetwork.load("HOU.nnet");
    NeuralNetwork nn12 = NeuralNetwork.load("IND.nnet");
    NeuralNetwork nn13 = NeuralNetwork.load("LAC.nnet");
    NeuralNetwork nn14 = NeuralNetwork.load("LAL.nnet");
    NeuralNetwork nn15 = NeuralNetwork.load("MEM.nnet");
    NeuralNetwork nn16 = NeuralNetwork.load("MIA.nnet");
    NeuralNetwork nn17 = NeuralNetwork.load("MIL.nnet");
    NeuralNetwork nn18 = NeuralNetwork.load("MIN.nnet");
    NeuralNetwork nn19 = NeuralNetwork.load("NOH.nnet");
    NeuralNetwork nn20 = NeuralNetwork.load("NYK.nnet");
    NeuralNetwork nn21 = NeuralNetwork.load("OKC.nnet");
    NeuralNetwork nn22 = NeuralNetwork.load("ORL.nnet");
    NeuralNetwork nn23 = NeuralNetwork.load("PHI.nnet");
    NeuralNetwork nn24 = NeuralNetwork.load("PHO.nnet");
    NeuralNetwork nn25 = NeuralNetwork.load("POR.nnet");
    NeuralNetwork nn26 = NeuralNetwork.load("SAC.nnet");
    NeuralNetwork nn27 = NeuralNetwork.load("SAS.nnet");
    NeuralNetwork nn28 = NeuralNetwork.load("TOR.nnet");
    NeuralNetwork nn29 = NeuralNetwork.load("UTA.nnet");
    NeuralNetwork nn30 = NeuralNetwork.load("WAS.nnet");
    
    double[] T1 = null;
    double[] T2 = null;
    
    boolean homeWin;
    double diff;
    
    public void setHomeATL()
    {
        T1 = ATL;
    }
    public void setHomeBOS()
    {
        T1 = BOS;
    }
    public void setHomeBRK()
    {
        T1 = BRK;
    }
    public void setHomeCHA()
    {
        T1 = CHA;
    }
	public void setHomeCHI()
    {
        T1 = CHI;
    }
	public void setHomeCLE()
    {
        T1 = CLE;
    }
	public void setHomeDAL()
    {
        T1 = DAL;
    }
	public void setHomeDEN()
    {
        T1 = DEN;
    }
	public void setHomeDET()
    {
        T1 = DET;
    }
	public void setHomeGSW()
    {
        T1 = GSW;
    }
	public void setHomeHOU()
    {
        T1 = HOU;
    }
	public void setHomeIND()
    {
        T1 = IND;
    }
	public void setHomeLAC()
    {
        T1 = LAC;
    }
	public void setHomeLAL()
    {
        T1 = LAL;
    }
	public void setHomeMEM()
    {
        T1 = MEM;
    }
	public void setHomeMIA()
    {
        T1 = MIA;
    }
	public void setHomeMIL()
    {
        T1 = MIL;
    }
	public void setHomeMIN()
    {
        T1 = MIN;
    }
	public void setHomeNOH()
    {
        T1 = NOH;
    }
	public void setHomeNYK()
    {
        T1 = NYK;
    }
	public void setHomeOKC()
    {
        T1 = OKC;
    }
	public void setHomeORL()
    {
        T1 = ORL;
    }
	public void setHomePHI()
    {
        T1 = PHI;
    }
	public void setHomePHO()
    {
        T1 = PHO;
    }
	public void setHomePOR()
    {
        T1 = POR;
    }
	public void setHomeSAC()
    {
        T1 = SAC;
    }
	public void setHomeSAS()
    {
        T1 = SAS;
    }
	public void setHomeTOR()
    {
        T1 = TOR;
    }
	public void setHomeUTA()
    {
        T1 = UTA;
    }
	public void setHomeWAS()
    {
        T1 = WAS;
    }
    
    public void setAwayATL()
    {
        T2 = ATL;
    }
    public void setAwayBOS()
    {
        T2 = BOS;
    }
    public void setAwayBRK()
    {
        T2 = BRK;
    }
    public void setAwayCHA()
    {
        T2 = CHA;
    }
	public void setAwayCHI()
    {
        T2 = CHI;
    }
	public void setAwayCLE()
    {
        T2 = CLE;
    }
	public void setAwayDAL()
    {
        T2 = DAL;
    }
	public void setAwayDEN()
    {
        T2 = DEN;
    }
	public void setAwayDET()
    {
        T2 = DET;
    }
	public void setAwayGSW()
    {
        T2 = GSW;
    }
	public void setAwayHOU()
    {
        T2 = HOU;
    }
	public void setAwayIND()
    {
        T2 = IND;
    }
	public void setAwayLAC()
    {
        T2 = LAC;
    }
	public void setAwayLAL()
    {
        T2 = LAL;
    }
	public void setAwayMEM()
    {
        T2 = MEM;
    }
	public void setAwayMIA()
    {
        T2 = MIA;
    }
	public void setAwayMIL()
    {
        T2 = MIL;
    }
	public void setAwayMIN()
    {
        T2 = MIN;
    }
	public void setAwayNOH()
    {
        T2 = NOH;
    }
	public void setAwayNYK()
    {
        T2 = NYK;
    }
	public void setAwayOKC()
    {
        T2 = OKC;
    }
	public void setAwayORL()
    {
        T2 = ORL;
    }
	public void setAwayPHI()
    {
        T2 = PHI;
    }
	public void setAwayPHO()
    {
        T2 = PHO;
    }
	public void setAwayPOR()
    {
        T2 = POR;
    }
	public void setAwaySAC()
    {
        T2 = SAC;
    }
	public void setAwaySAS()
    {
        T2 = SAS;
    }
	public void setAwayTOR()
    {
        T2 = TOR;
    }
	public void setAwayUTA()
    {
        T2 = UTA;
    }
	public void setAwayWAS()
    {
        T2 = WAS;
    }
    
    public void predict()
    {
        double[] networkOutput = null;
        if(T1 == ATL)
        {
            nn1.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn1.calculate();
            networkOutput = nn1.getOutput();
        }
        else if(T1 == BOS)
        {
            nn2.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn2.calculate();
            networkOutput = nn2.getOutput();
        }
        else if(T1 == BRK)
        {
            nn3.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn3.calculate();
            networkOutput = nn3.getOutput();
        }
        else if(T1 == CHA)
        {
            nn4.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn4.calculate();
            networkOutput = nn4.getOutput();
        }
        else if(T1 == CHI)
        {
            nn5.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn5.calculate();
            networkOutput = nn5.getOutput();
        }
        else if(T1 == CLE)
        {
            nn6.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn6.calculate();
            networkOutput = nn6.getOutput();
        }
        else if(T1 == DAL)
        {
            nn7.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn7.calculate();
            networkOutput = nn7.getOutput();
        }
        else if(T1 == DEN)
        {
            nn8.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn8.calculate();
            networkOutput = nn8.getOutput();
        }
        else if(T1 == DET)
        {
            nn9.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn9.calculate();
            networkOutput = nn9.getOutput();
        }
        else if(T1 == GSW)
        {
            nn10.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn10.calculate();
            networkOutput = nn10.getOutput();
        }
        else if(T1 == HOU)
        {
            nn11.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn11.calculate();
            networkOutput = nn11.getOutput();
        }
        else if(T1 == IND)
        {
            nn12.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn12.calculate();
            networkOutput = nn12.getOutput();
        }
        else if(T1 == LAC)
        {
            nn13.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn13.calculate();
            networkOutput = nn13.getOutput();
        }
        else if(T1 == LAL)
        {
            nn14.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn14.calculate();
            networkOutput = nn14.getOutput();
        }
        else if(T1 == MEM)
        {
            nn15.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn15.calculate();
            networkOutput = nn15.getOutput();
        }
        else if(T1 == MIA)
        {
            nn16.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn16.calculate();
            networkOutput = nn16.getOutput();
        }
        else if(T1 == MIL)
        {
            nn17.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn17.calculate();
            networkOutput = nn17.getOutput();
        }
        else if(T1 == MIN)
        {
            nn18.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn18.calculate();
            networkOutput = nn18.getOutput();
        }
        else if(T1 == NOH)
        {
            nn19.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn19.calculate();
            networkOutput = nn19.getOutput();
        }
        else if(T1 == NYK)
        {
            nn20.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn20.calculate();
            networkOutput = nn20.getOutput();
        }
        else if(T1 == OKC)
        {
            nn21.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn21.calculate();
            networkOutput = nn21.getOutput();
        }
        else if(T1 == ORL)
        {
            nn22.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn22.calculate();
            networkOutput = nn22.getOutput();
        }
        else if(T1 == PHI)
        {
            nn23.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn23.calculate();
            networkOutput = nn23.getOutput();
        }
        else if(T1 == PHO)
        {
            nn24.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn24.calculate();
            networkOutput = nn24.getOutput();
        }
        else if(T1 == POR)
        {
            nn25.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn25.calculate();
            networkOutput = nn25.getOutput();
        }
        else if(T1 == SAC)
        {
            nn26.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn26.calculate();
            networkOutput = nn26.getOutput();
        }
        else if(T1 == SAS)
        {
            nn27.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn27.calculate();
            networkOutput = nn27.getOutput();
        }
        else if(T1 == TOR)
        {
            nn28.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn28.calculate();
            networkOutput = nn28.getOutput();
        }
        else if(T1 == UTA)
        {
            nn29.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn29.calculate();
            networkOutput = nn29.getOutput();
        }
        else if(T1 == WAS)
        {
            nn30.setInput(new double[]{T1[0], T1[1], T1[2], T1[3], T1[4], T1[5], T1[6], T1[7], T1[8], T1[9], T1[10], T1[11], T2[0], T2[1], T2[2], T2[3], T2[4], T2[5], T2[6], T2[7], T2[8], T2[9], T2[10], T2[11], 1, 0});
            nn30.calculate();
            networkOutput = nn30.getOutput();
        }
        
        if(networkOutput[0] > networkOutput[1])
        {
            homeWin = true;
        }
        else
        {
            homeWin = false;
        }
        diff = networkOutput[0] - networkOutput[1];
    }
    
    boolean getResult()
    {
        return homeWin;
    }
    
    double getDiff()
    {
        return diff;
    }
    
    boolean ready()
    {
        return T1!=null && T2!=null;
    }
}