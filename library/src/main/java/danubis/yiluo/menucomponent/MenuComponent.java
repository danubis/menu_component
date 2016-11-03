package danubis.yiluo.menucomponent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class MenuComponent extends RelativeLayout implements View.OnTouchListener {

    public static final int MENU_BUTTON = 0;
    public static final int BUTTON_1 = 1;
    public static final int BUTTON_2 = 2;
    public static final int BUTTON_3 = 3;
    public static final int BUTTON_4 = 4;
    public static final int BUTTON_5 = 5;

    private boolean isMenuOpened = false;
    private int fromPosX;
    private int fromPosY;
    private int movePx;

    private MenuButtonFunctions buttonFunctions;

    private ImageView menuButton;
    private ImageView button1;
    private ImageView button2;
    private ImageView button3;
    private ImageView button4;
    private ImageView button5;

    List<ImageView> buttons;


    public MenuComponent(Context context) {
        super(context);
    }

    public MenuComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    public void init(int fromPosX, int fromPosY, int movePx, MenuButtonFunctions buttonFunctions) {

        this.fromPosX = fromPosX;
        this.fromPosY = fromPosY;
        this.movePx = movePx;
        this.buttonFunctions = buttonFunctions;

        inflate(getContext(), R.layout.menu_component, this);
        menuButton = (ImageView) findViewById(R.id.menu_component_menu_button);
        button1 = (ImageView) findViewById(R.id.menu_component_button_1);
        button2 = (ImageView) findViewById(R.id.menu_component_button_2);
        button3 = (ImageView) findViewById(R.id.menu_component_button_3);
        button4 = (ImageView) findViewById(R.id.menu_component_button_4);
        button5 = (ImageView) findViewById(R.id.menu_component_button_5);

        menuButton.setOnTouchListener(this);
        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);
        button5.setOnTouchListener(this);

        buttons = new ArrayList<>();
        buttons.add(menuButton);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        for(ImageView button:buttons){
            if (button.getId()!=R.id.menu_component_menu_button) {
                button.setVisibility(GONE);
            }
        }
    }

    public void init(int fromPosX, int fromPosY, int movePx, MenuButtonFunctions buttonFunctions,int[] buttonids) {

        this.fromPosX = fromPosX;
        this.fromPosY = fromPosY;
        this.movePx = movePx;
        this.buttonFunctions = buttonFunctions;

        inflate(getContext(), R.layout.menu_component, this);
        menuButton = (ImageView) findViewById(R.id.menu_component_menu_button);
        button1 = (ImageView) findViewById(R.id.menu_component_button_1);
        button2 = (ImageView) findViewById(R.id.menu_component_button_2);
        button3 = (ImageView) findViewById(R.id.menu_component_button_3);
        button4 = (ImageView) findViewById(R.id.menu_component_button_4);
        button5 = (ImageView) findViewById(R.id.menu_component_button_5);

        menuButton.setImageResource(buttonids[0]);
        button1.setImageResource(buttonids[1]);
        button2.setImageResource(buttonids[2]);
        button3.setImageResource(buttonids[3]);
        button4.setImageResource(buttonids[4]);
        button5.setImageResource(buttonids[5]);

        menuButton.setOnTouchListener(this);
        button1.setOnTouchListener(this);
        button2.setOnTouchListener(this);
        button3.setOnTouchListener(this);
        button4.setOnTouchListener(this);
        button5.setOnTouchListener(this);

        buttons = new ArrayList<>();
        buttons.add(menuButton);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);

        for(ImageView button:buttons){
            if (button.getId()!=R.id.menu_component_menu_button) {
                button.setVisibility(GONE);
            }
        }

    }


    public void updateMenuButtons(boolean isMenuOpened) {

        ObjectAnimator moveButton1 = ObjectAnimator.ofFloat(button1, "y", fromPosY, fromPosY - movePx);

        ObjectAnimator moveButton2X = ObjectAnimator.ofFloat(button2, "x", fromPosX, (int) (movePx * Math.sin(22.5 * Math.PI / 180)));
        ObjectAnimator moveButton2Y = ObjectAnimator.ofFloat(button2, "y", fromPosY, fromPosY - (int) (movePx * Math.sin(67.5 * Math.PI / 180)));

        ObjectAnimator moveButton3X = ObjectAnimator.ofFloat(button3, "x", fromPosX, (int) (movePx * Math.sin(45 * Math.PI / 180)));
        ObjectAnimator moveButton3Y = ObjectAnimator.ofFloat(button3, "y", fromPosY, fromPosY - (int) (movePx * Math.sin(45 * Math.PI / 180)));

        ObjectAnimator moveButton4X = ObjectAnimator.ofFloat(button4, "x", fromPosX, (int) (movePx * Math.cos(22.5 * Math.PI / 180)));
        ObjectAnimator moveButton4Y = ObjectAnimator.ofFloat(button4, "y", fromPosY, fromPosY - (int) (movePx * Math.cos(67.5 * Math.PI / 180)));

        ObjectAnimator moveButton5 = ObjectAnimator.ofFloat(button5, "x", fromPosX, movePx);

        ObjectAnimator changeButton1Alpha = ObjectAnimator.ofFloat(button1, "alpha", 0f, 1f);
        ObjectAnimator changeButton2Alpha = ObjectAnimator.ofFloat(button2, "alpha", 0f, 1f);
        ObjectAnimator changeButton3Alpha = ObjectAnimator.ofFloat(button3, "alpha", 0f, 1f);
        ObjectAnimator changeButton4Alpha = ObjectAnimator.ofFloat(button4, "alpha", 0f, 1f);
        ObjectAnimator changeButton5Alpha = ObjectAnimator.ofFloat(button5, "alpha", 0f, 1f);

        if (!isMenuOpened) {

            for (ImageView button : buttons) {
                if (button.getId()!=R.id.menu_component_menu_button) {
                    button.setVisibility(VISIBLE);
                }
            }

            AnimatorSet showButtons = new AnimatorSet();
            showButtons.setDuration(150);
            showButtons.playTogether(moveButton1, moveButton2X, moveButton2Y, moveButton3X,
                    moveButton3Y, moveButton4X, moveButton4Y, moveButton5, changeButton1Alpha,
                    changeButton2Alpha, changeButton3Alpha, changeButton4Alpha, changeButton5Alpha);
            showButtons.start();

        } else {


            moveButton1 = ObjectAnimator.ofFloat(button1, "y", fromPosY - movePx, fromPosY);

            moveButton2Y = ObjectAnimator.ofFloat(button2, "y", fromPosY - (int) (movePx * Math.sin(67.5 * Math.PI / 180)), fromPosY);
            moveButton2X = ObjectAnimator.ofFloat(button2, "x", (int) (movePx * Math.sin(22.5 * Math.PI / 180)), fromPosX);

            moveButton3Y = ObjectAnimator.ofFloat(button3, "y", fromPosY - (int) (movePx * Math.sin(45 * Math.PI / 180)), fromPosY);
            moveButton3X = ObjectAnimator.ofFloat(button3, "x", (int) (movePx * Math.sin(45 * Math.PI / 180)), fromPosX);

            moveButton4Y = ObjectAnimator.ofFloat(button4, "y", fromPosY - (int) (movePx * Math.cos(67.5 * Math.PI / 180)), fromPosY);
            moveButton4X = ObjectAnimator.ofFloat(button4, "x", (int) (movePx * Math.cos(22.5 * Math.PI / 180)), fromPosX);

            moveButton5 = ObjectAnimator.ofFloat(button5, "x", movePx, fromPosX);

            changeButton1Alpha = ObjectAnimator.ofFloat(button1, "alpha", 1f, 0f);
            changeButton2Alpha = ObjectAnimator.ofFloat(button2, "alpha", 1f, 0f);
            changeButton3Alpha = ObjectAnimator.ofFloat(button3, "alpha", 1f, 0f);
            changeButton4Alpha = ObjectAnimator.ofFloat(button4, "alpha", 1f, 0f);
            changeButton5Alpha = ObjectAnimator.ofFloat(button5, "alpha", 1f, 0f);

            AnimatorSet hideButtons = new AnimatorSet();
            hideButtons.setDuration(150);
            hideButtons.playTogether(moveButton1, moveButton2X, moveButton2Y, moveButton3X,
                    moveButton3Y, moveButton4X, moveButton4Y, moveButton5, changeButton1Alpha,
                    changeButton2Alpha, changeButton3Alpha, changeButton4Alpha, changeButton5Alpha);
            hideButtons.start();
            hideButtons.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationEnd(Animator animation) {
                    for (ImageView button : buttons) {
                        if (button.getId()!=R.id.menu_component_menu_button) {
                            button.setVisibility(GONE);
                        }
                    }
                }

                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });

        }
    }


    public void buttonOnTouchEvent(int buttonId, boolean isPressed) {

        if (isPressed) {
            buttons.get(buttonId).setAlpha(0.5f);
        } else {
            buttons.get(buttonId).setAlpha(1f);
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

                if (view.getId() == R.id.menu_component_button_1) {
                    buttonOnTouchEvent(BUTTON_1, true);

                } else if (view.getId() == R.id.menu_component_button_2) {
                    buttonOnTouchEvent(BUTTON_2, true);

                } else if (view.getId() == R.id.menu_component_button_3) {
                    buttonOnTouchEvent(BUTTON_3, true);

                } else if (view.getId() == R.id.menu_component_button_4) {
                    buttonOnTouchEvent(BUTTON_4, true);

                } else if (view.getId() == R.id.menu_component_button_5) {
                    buttonOnTouchEvent(BUTTON_5, true);

                } else if (view.getId() == R.id.menu_component_menu_button) {
                    buttonOnTouchEvent(MENU_BUTTON, true);
                }

                break;

            case MotionEvent.ACTION_UP:
                if (view.getId() == R.id.menu_component_button_1) {
                    buttonOnTouchEvent(BUTTON_1, false);
                    buttonFunctions.button1Function();

                } else if (view.getId() == R.id.menu_component_button_2) {
                    buttonOnTouchEvent(BUTTON_2, false);
                    buttonFunctions.button2Function();

                } else if (view.getId() == R.id.menu_component_button_3) {
                    buttonOnTouchEvent(BUTTON_3, false);
                    buttonFunctions.button3Function();

                } else if (view.getId() == R.id.menu_component_button_4) {
                    buttonOnTouchEvent(BUTTON_4, false);
                    buttonFunctions.button4Function();

                } else if (view.getId() == R.id.menu_component_button_5) {
                    buttonOnTouchEvent(BUTTON_5, false);
                    buttonFunctions.button5Function();

                } else if (view.getId() == R.id.menu_component_menu_button) {
                    buttonOnTouchEvent(MENU_BUTTON, false);
                }

                updateMenuButtons(isMenuOpened);
                isMenuOpened = !isMenuOpened;

                break;
        }
        return true;
    }
}