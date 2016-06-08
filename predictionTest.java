
public class predictionTest {
	public static void main(String[] args)
	{
		predictor nn = new predictor();
		nn.setHomeLAL();
		nn.setAwayLAL();
		nn.predict();
		System.out.print(nn.getResult());
	}
}
