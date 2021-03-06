package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WebViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        //여기서 웹뷰 연동하기
        val webview = findViewById<WebView>(R.id.webview)
        webview.loadUrl(intent.getStringExtra("url").toString())
        //여기까지 하면 웹뷰 연결 끝.

        //이제 북마크 해주자  --> 파이어베이스 연동
        auth = Firebase.auth
        //데이터베이스 데이터 읽기 위한 코드
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark")  //어느 경로에 저장할거냐고 묻는거야

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()
        //모든 정보 다 받아오기.
        //웹뷰 연결까지 끝.


//        웹뷰에서는 북마크 X
//        val saveBtn = findViewById<TextView>(R.id.saveBtn)
//        saveBtn.setOnClickListener {
//            Toast.makeText(this, "북마크 저장 완료", Toast.LENGTH_LONG).show()
//            myBookmarkRef.child(auth.currentUser!!.uid).push()   //내 uid기반으로 저장해야함. push() 항상 써줘야 됨
//                .setValue(MangoModel(url, imageUrl, title))    //ContentModel전체를 저장해서 갖다 쓰자
//        }
    }
}