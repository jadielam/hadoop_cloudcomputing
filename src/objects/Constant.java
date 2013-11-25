package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Constant implements Writable {
        
        private IntWritable id;
        private Text text;
        
        public Constant()
        {
        	this.id=new IntWritable(1);
        	this.text=new Text("");
        }
        
        public Constant(int id, String text) {
                this.id = new IntWritable(id);
                this.text = new Text(text);
        }        
        
        public IntWritable getId() {
                return id;
        }
        
        public Text getText() {
                return text;
        }
        
        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Constant other = (Constant) obj;
                if (id != other.id)
                        return false;
                if (text == null) {
                        if (other.text != null)
                                return false;
                } else if (!text.equals(other.text))
                        return false;
                return true;
        }
        
        public void write(DataOutput out) throws IOException{
                id.write(out);
                text.write(out);
        }
        
        public void readFields(DataInput in) throws IOException {
                id.readFields(in);
                text.readFields(in);
        }
         @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + id.get();
                result = prime * result + ((text == null) ? 0 : text.hashCode());
                return result;
        }
         
         public int compareTo(Object other ) {  
            int result = 0;
                return result;
          }  

         public String toString(){
                 return text.toString();
         }
}
