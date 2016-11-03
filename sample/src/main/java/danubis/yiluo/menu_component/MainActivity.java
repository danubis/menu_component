package danubis.yiluo.menu_component;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import danubis.yiluo.menucomponent.MenuButtonFunctions;
import danubis.yiluo.menucomponent.MenuComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenHeight = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        int posX = dip2px(this, 65);
        int posY = screenHeight - posX;
        int movePx = screenHeight / 4;

        int[] buttonIds = {R.drawable.menu_button,
                R.drawable.back_button,
                R.drawable.map_button,
                R.drawable.camera,
                R.drawable.flight,
                R.drawable.shop_button};

        MenuComponent menuComponent = (MenuComponent) findViewById(R.id.menu);
        menuComponent.init(posX, posY, movePx, new MenuButtonFunctions() {
            @Override
            public void button1Function() {
                Log.e("menucomponentsample", "button 1 clicked...");
            }

            @Override
            public void button2Function() {
                Log.e("menucomponentsample", "button 2 clicked...");
            }

            @Override
            public void button3Function() {
                Log.e("menucomponentsample", "button 3 clicked...");
            }

            @Override
            public void button4Function() {
                Log.e("menucomponentsample", "button 4 clicked...");
            }

            @Override
            public void button5Function() {
                Log.e("menucomponentsample", "button 5 clicked...");
            }
        }, buttonIds);
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
