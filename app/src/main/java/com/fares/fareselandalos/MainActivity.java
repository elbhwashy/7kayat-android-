package com.fares.fareselandalos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(new Chapter("حكاية السندباد"));
        chapters.add(new Chapter("الجزيرة المتحركة والخيول البحرية"));
        chapters.add(new Chapter("وادي الألماس"));
        chapters.add(new Chapter("الغول الأسود"));
        chapters.add(new Chapter("السندباد يدفن حيا"));
        chapters.add(new Chapter("شيخ البحر"));
        chapters.add(new Chapter("رحلة نهرية في كهف"));
        chapters.add(new Chapter("مقبرة الافيال"));

        ListView chapterListView = (ListView) findViewById(R.id.list);
        ChapterAdapter adapter =new ChapterAdapter(this,chapters);
        chapterListView.setAdapter(adapter);
chapterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(MainActivity.this, WebHtml.class);
        intent.putExtra("page", position);
        startActivity(intent);
    }
});

    }

    public void sendMail(View view) {
       try {
           String text = "welcome: \n please tel me your opinoin";
           Intent sendEmail = new Intent(Intent.ACTION_SEND);
           sendEmail.setData(Uri.parse("mailto"));
           sendEmail.setType("message/rfc822");
           sendEmail.putExtra(Intent.EXTRA_EMAIL, "sobhyelbhwashy@gmail.com");
           sendEmail.putExtra(Intent.EXTRA_SUBJECT, " 7kayat Elsendbad.");
           sendEmail.putExtra(Intent.EXTRA_TEXT, text);
           startActivity(sendEmail);
       }catch (Exception e ){
           Toast.makeText(this,"sorry no app mail",Toast.LENGTH_LONG).show();
       }
    }

    public void viewStore(View view) {
        Intent viewStore = new Intent(Intent.ACTION_VIEW);
        viewStore.setData(Uri.parse("https://play.google.com/apps/developer?id="));
        startActivity(viewStore);
    }

    public void share(View view) {
        String textShare = "تطبيق حكايات السندباد";
        String shareLink = "https://play.google.com/store/apps/details?id=com.fares.fareselandalos";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,textShare + "\n" + shareLink);
        startActivity(share);
    }

    public void closeView(View view) {
        Toast.makeText(this," Exit ",Toast.LENGTH_LONG).show();
        finish();
    }
}
