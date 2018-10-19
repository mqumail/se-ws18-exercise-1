package exercise1;

public class Image {
  public byte[] data;
  private int width;
  private int height;

  public Image(int width, int height){
    //Create the aray with the length according to the given Width and Height
	this.width = width;
	this.height = height;
	int length = width * height * 3;
    data = new byte[length];

    //Set the bytes of the array to 00
    for(int i = 0; i <= data.length; i++){
        data[i]=(byte)0x00;
    }
  }

  public void set(int x, int y, int val){
    int index;
    if(x == 0 && y == 0){
      index = 0;
    } else if(y == 0 && x != 0){
      index = x * 3;
    } else if(x == 0 && y != 0){
      index = x * (this.width * 3);
    } else{
      index = x * y;
    }

    String hexaValue = Integer.toString(val);
    char[] charArray = hexaValue.toCharArray();
    int r = Character.getNumericValue(charArray[0] + charArray[1]);
    int g = Character.getNumericValue(charArray[2] + charArray[3]);
    int b = Character.getNumericValue(charArray[4] + charArray[5]);

    data[index] = (byte)r;
    data[index+1] = (byte)g;
    data[index+2] = (byte)b;
  }

  public void write(String filename){
  }

}
