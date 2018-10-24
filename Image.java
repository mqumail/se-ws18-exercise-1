import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Image {
    public byte[] data;
    private int width;
    private int height;

    //Constructor of the image object
    public Image(int width, int height){
        //Create the array with the length according to the given Width and Height
        this.width = width;
        this.height = height;
        int arraySize = width * height * 3;
        data = new byte[arraySize];

        //Set the values of the byte  array to 00
        for(int i = 0; i < data.length; i++){
            data[i]=(byte)0x00;
        }
    }

    //Create getters
    public byte[] getData(){
      return this.data;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    //Create setters
    public void setData(byte[] updateData){
        this.data = updateData;
    }
    public void setWidth(int newWidth){
        this.width = newWidth;
    }
    public void setHeight(int newHeight){
        this.height = newHeight;
    }

    //Set method to insert values into the byte array and exceptions when the coordinates are too low or too high to calculate regularly
    public void set(int x, int y, int val){
        int index;
        if(x < width || y < height) {

            if (x == 0 && y == 0) {
                index = 0;
            } else if (y == 0 && x != 0) {
                index = x * 3;
            } else if (x == 0 && y != 0) {
                index = y * (width * 3);
            } else {
                index = (3 * width * height) - ((width - x) * 3);
            }

            //Set the values of the array by the given int value(val) shifting 8 bits from val value
            //https://stackoverflow.com/questions/2183240/java-integer-to-byte-array used the >> operator to shift the values properly
            data[index] = (byte) (val >> 16);
            data[index + 1] = (byte) (val >> 8);
            data[index + 2] = (byte) (val >> 0);

        }
    }

  public void write(String filename){

      // Reference: https://www.journaldev.com/878/java-write-to-file
      File file = new File(filename);
      FileWriter fr = null;

      try
      {
          fr = new FileWriter(file);
          // Write data instead
          String ppmHeader = "P6 " + width + " " + height + " " + 255 + "\n";
          String ppmData = "";
          for (int i = 0; i < data.length; i++)
          {
              ppmData = ppmData + data[i] + "\n";
          }
          fr.write(ppmHeader);
          fr.write(ppmData);
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try
          {
              fr.close();
          } catch (IOException e)
          {
              e.printStackTrace();
          }
      }
  }

}
