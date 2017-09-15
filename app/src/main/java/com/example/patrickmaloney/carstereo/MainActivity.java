package com.example.patrickmaloney.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import static android.R.color.holo_blue_bright;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton powerButton;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;
    private Button skipButton;
    private Button repeatButton;
    private SeekBar volume;
    private SeekBar AMtuner;
    private SeekBar FMtuner;
    private TextView stationScreen;
    private RadioGroup AMFMGroup;
    private RadioButton AMButton;
    private RadioButton FMButton;
    private RadioGroup presetGroup;
    private RadioButton preset1;
    private RadioButton preset2;
    private RadioButton preset3;
    private RadioButton preset4;
    private RadioButton preset5;
    private RadioButton preset6;

    private boolean powerOn = false;
    private boolean amfm = false;

    private int am1 = 550;
    private int am2 = 600;
    private int am3 = 650;
    private int am4 = 700;
    private int am5 = 750;
    private int am6 = 800;
    private int fm1 = 909;
    private int fm2 = 929;
    private int fm3 = 949;
    private int fm4 = 969;
    private int fm5 = 989;
    private int fm6 = 1009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerButton = (ToggleButton)findViewById(R.id.power_button);
        playButton = (Button)findViewById(R.id.play_button);
        pauseButton = (Button)findViewById(R.id.pause_button);
        stopButton = (Button)findViewById(R.id.stop_button);
        skipButton = (Button)findViewById(R.id.skip_button);
        repeatButton = (Button)findViewById(R.id.repeat_button);
        volume = (SeekBar)findViewById(R.id.volume);
        AMtuner = (SeekBar)findViewById(R.id.AM_tuner);
        FMtuner = (SeekBar)findViewById(R.id.FM_tuner);
        stationScreen = (TextView)findViewById(R.id.station);
        AMFMGroup = (RadioGroup) findViewById(R.id.AMFM_group);
        AMButton = (RadioButton)findViewById(R.id.AM_button);
        FMButton = (RadioButton)findViewById(R.id.FM_button);
        presetGroup = (RadioGroup)findViewById(R.id.preset_group);
        preset1 = (RadioButton)findViewById(R.id.preset1);
        preset2 = (RadioButton)findViewById(R.id.preset2);
        preset3 = (RadioButton)findViewById(R.id.preset3);
        preset4 = (RadioButton)findViewById(R.id.preset4);
        preset5 = (RadioButton)findViewById(R.id.preset5);
        preset6 = (RadioButton)findViewById(R.id.preset6);

        powerButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);
        repeatButton.setOnClickListener(this);




        AMtuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean user) {
                stationScreen.setText("Station: "+(progress+530)+" AM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {}

            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });

        FMtuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean user) {
                stationScreen.setText("Station: "+(float)(progress+881)/10+" FM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {}

            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });

        AMFMGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(powerOn == true) {
                    if (checkedId == R.id.AM_button) {
                        AMtuner.setEnabled(true);
                        FMtuner.setEnabled(false);
                        amfm = false;
                    } else {
                        AMtuner.setEnabled(false);
                        FMtuner.setEnabled(true);
                        amfm = true;
                    }
                }
            }
        });

        presetGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(powerOn == true) {
                    if(checkedId == R.id.preset1 && amfm == false){
                        stationScreen.setText("Station: "+am1+" AM");
                    }
                    else if(checkedId == R.id.preset2 && amfm == false){
                        stationScreen.setText("Station: "+am2+" AM");
                    }
                    else if(checkedId == R.id.preset3 && amfm == false){
                        stationScreen.setText("Station: "+am3+" AM");
                    }
                    else if(checkedId == R.id.preset4 && amfm == false){
                        stationScreen.setText("Station: "+am4+" AM");
                    }
                    else if(checkedId == R.id.preset5 && amfm == false){
                        stationScreen.setText("Station: "+am5+" AM");
                    }
                    else if(checkedId == R.id.preset6 && amfm == false){
                        stationScreen.setText("Station: "+am6+" AM");
                    }
                    else if(checkedId == R.id.preset1 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm1/10)+" FM");
                    }
                    else if(checkedId == R.id.preset2 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm2/10)+" FM");
                    }
                    else if(checkedId == R.id.preset3 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm3/10)+" FM");
                    }
                    else if(checkedId == R.id.preset4 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm4/10)+" FM");
                    }
                    else if(checkedId == R.id.preset5 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm5/10)+" FM");
                    }
                    else if(checkedId == R.id.preset6 && amfm == true){
                        stationScreen.setText("Station: "+(float)(fm6/10)+" FM");
                    }

                }
            }
        });

        presetGroup.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                if(v == preset1 && amfm){
                    am1 = AMtuner.getProgress();
                }
                else if(v == preset2 && amfm){
                    am2 = AMtuner.getProgress();
                }
                else if(v == preset3 && amfm){
                    am3 = AMtuner.getProgress();
                }
                else if(v == preset4 && amfm){
                    am4 = AMtuner.getProgress();
                }
                else if(v == preset5 && amfm){
                    am5 = AMtuner.getProgress();
                }
                else if(v == preset6 && amfm){
                    am6 = AMtuner.getProgress();
                }
                else if(v == preset1 && amfm == false){
                    fm1 = FMtuner.getProgress();
                }
                else if(v == preset2 && amfm == false){
                    fm2 = FMtuner.getProgress();
                }
                else if(v == preset3 && amfm == false){
                    fm3 = FMtuner.getProgress();
                }
                else if(v == preset4 && amfm == false){
                    fm4 = FMtuner.getProgress();
                }
                else if(v == preset5 && amfm == false){
                    fm5 = FMtuner.getProgress();
                }
                else if(v == preset6 && amfm == false){
                    fm6 = FMtuner.getProgress();
                }
                return true;
            }
        });




        playButton.setEnabled(false);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        skipButton.setEnabled(false);
        repeatButton.setEnabled(false);
        volume.setEnabled(false);
        AMtuner.setEnabled(false);
        FMtuner.setEnabled(false);
        stationScreen.setBackgroundColor(Color.DKGRAY);

    }

    @Override
    public void onClick(View v){
        if(v == powerButton && powerOn == false){
            powerOn = true;
            powerButton.setBackgroundColor(Color.GREEN);
            playButton.setEnabled(powerOn);
            pauseButton.setEnabled(powerOn);
            stopButton.setEnabled(powerOn);
            skipButton.setEnabled(powerOn);
            repeatButton.setEnabled(powerOn);
            volume.setEnabled(powerOn);
            stationScreen.setBackgroundColor(Color.parseColor("#ff00ddff"));
            AMButton.setClickable(powerOn);
            FMButton.setClickable(powerOn);


        }
        else if(v == powerButton && powerOn == true){
            powerOn = false;
            powerButton.setBackgroundResource(android.R.drawable.btn_default);;
            playButton.setEnabled(powerOn);
            pauseButton.setEnabled(powerOn);
            stopButton.setEnabled(powerOn);
            skipButton.setEnabled(powerOn);
            repeatButton.setEnabled(powerOn);
            volume.setEnabled(powerOn);
            stationScreen.setBackgroundColor(Color.DKGRAY);
            AMFMGroup.setEnabled(powerOn);
            AMButton.setClickable(powerOn);
            FMButton.setClickable(powerOn);

        }

    }
}
