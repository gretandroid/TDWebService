package com.example.myapplicationwebservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.myapplicationwebservice.databinding.ActivityMainBinding
import com.example.myapplicationwebservice.model.Article
import com.example.myapplicationwebservice.webservice.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.allarticles.setOnClickListener{
          CoroutineScope(Dispatchers.Main).launch{
              var bool=true
              binding.progressBar.visibility=VISIBLE

              withContext(Dispatchers.IO){
               //   Thread.sleep(3000)
                  try {
            val articles = RetrofitInstance.instance.getArticle()
            Log.d("articles", articles.toString())
                  bool=false
                  } catch(e: Exception){
                      Log.e("Error","Exception $e")
                  }

              }
                if (!bool ) binding.progressBar.visibility=GONE
          }
        }
        binding.insertarticle.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val article = Article(0,13,"Titre13","contenu 13")
                try {
                    val article1 = RetrofitInstance.instance.createArticle(article)
                    Log.d("articles", article1.toString())
                } catch(e: Exception){
                    Log.e("Error","Exception $e")
                }

            }
        }
        binding.updatearticle.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val article = Article(2,13,"Titre14","contenu 14")
                val article1 = RetrofitInstance.instance.updateArticle(2,article)
                Log.d("articles", article1.toString())

            }
        }
        binding.deletearticle.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{

                RetrofitInstance.instance.deleteArticle(2)


            }
        }






    }
}












