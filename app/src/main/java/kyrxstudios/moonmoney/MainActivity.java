package kyrxstudios.moonmoney;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener{

    RewardedVideoAd rewardedVideoAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //Creating ad objects
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());//I used the test ad id found at https://developers.google.com/admob/android/test-ads.

        //This is connecting the button from content_main.xml to this java doc
        final Button AdButton =  findViewById(R.id.AdButton);
        Log.d("AdButton ", "Clicked ");

        //Displays add when button is clicked.
        AdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rewardedVideoAd.isLoaded())
                {
                    rewardedVideoAd.show();
                }
                else
                    Toast.makeText(getApplication(), "Try again", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.d("Ad", "Loaded");
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    //This methods is where we know if the user watch the entire ad or not
    @Override
    public void onRewardedVideoAdClosed() {

    }

    //This is where we reward our user with how ever many coins we wante to show them
    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    //
    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(getApplication(), "Ad failed to load. Check Connection.", Toast.LENGTH_LONG).show();

    }
}
