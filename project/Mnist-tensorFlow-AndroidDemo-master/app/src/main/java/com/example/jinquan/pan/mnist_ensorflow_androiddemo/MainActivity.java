package com.example.jinquan.pan.mnist_ensorflow_androiddemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private static final String TAG = "MainActivity";
    private static final String MODEL_FILE = "file:///android_asset/mnist.pb"; //模型存放路径
    TextView txt;
    TextView tv;
    ImageView imageView;
    Bitmap bitmap;
    PredictionTF preTF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt_id);
        //initimg(getIntent());
        imageView =(ImageView)findViewById(R.id.imageView1);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_image);
        imageView.setImageBitmap(bitmap);
        preTF =new PredictionTF(getAssets(),MODEL_FILE);//输入模型存放路径，并加载TensoFlow模型
        // Example of a call to a native method
       if(getIntent().getStringExtra("label")!=null){
           Log.e("ini","no"+getIntent().getStringExtra("label"));
           initimg(getIntent());
       }else if(getIntent().hasExtra("bitmap")){
           imageView =(ImageView)findViewById(R.id.imageView1);
           Intent intent=getIntent();
           if(intent !=null)
           {
               Log.e("bit","here");
               byte [] bis=intent.getByteArrayExtra("bitmap");
               Bitmap bitmap1=BitmapFactory.decodeByteArray(bis, 0, bis.length);
               imageView.setImageBitmap(bitmap1);
               bitmap=bitmap1;

           }
       } else{
           Log.e("INI","yes");
           imageView =(ImageView)findViewById(R.id.imageView1);
           bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_image);
           imageView.setImageBitmap(bitmap);
       }
    }

    public void click01(View v){
        String res="预测结果为：";
        int[]result= preTF.getPredict(bitmap);
        String rr=result[0]+"";
        txt.setText(res+rr);
        //tv.setText(stringFromJNI());
    }
    public  void click02(View v){
        Intent intent=new Intent(this,list.class);
        startActivity(intent);
    }
    public void click03(View v){
        Intent intent=new Intent(this,sigActivity.class);
        startActivity(intent);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public void initimg(Intent intent){
        String label=intent.getStringExtra("label");
        imageView =(ImageView)findViewById(R.id.imageView1);
        if(label.contains("0")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test0);
            imageView.setImageBitmap(bitmap);
        } else if(label.contains("1")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
            imageView.setImageBitmap(bitmap);
        }else if(label.contains("2")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
            imageView.setImageBitmap(bitmap);
        }else if(label.contains("4")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test4);
            imageView.setImageBitmap(bitmap);
        }else if(label.contains("5")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test5);
            imageView.setImageBitmap(bitmap);
        }else if(label.contains("7")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test7);
            imageView.setImageBitmap(bitmap);
        }else if(label.contains("9")){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test9);
            imageView.setImageBitmap(bitmap);
        } 
    }
}
