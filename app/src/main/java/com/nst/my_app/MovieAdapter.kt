package com.nst.my_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
        var movieList = mutableListOf<Movie>()

       fun setMovies(movies: List<Movie>) {
          this.movieList = movies.toMutableList()
          notifyDataSetChanged()
       }
      fun searchdata(input : CharSequence){
          println("On_Submit3 "+input);
         // this.movieList.na
         //\
      //
      // notifyDataSetChanged()
      }



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewModel {
//     var inflate = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie,parent,false)
//        return MyViewHolder(inflate)
//    }
//
//    override fun onBindViewHolder(holder: MainViewModel, position: Int) {
//        holder.bind(movieList[position])
//    }
//
//    override fun getItemCount(): Int {
//       return movieList.size
//    }
//   class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
//       val name = view.findViewById<TextView>(R.id.name)
//       fun bind(data: Movie ){
//           println("Checkout pp"+data.name.toString())
//           name.text = data.name.toString()
//       }
//   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     var inflate = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie,parent,false)
      return MyViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        if (ValidationUtil.validateMovie(movie)) {
            holder.textView.text = movie.name
            //Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
            Glide.with(holder.imageView.context).load(movie.imageUrl).into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.name)
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
    }
}
//package com.velmurugan.mvvmwithkotlincoroutinesandretrofit
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.databinding.AdapterMovieBinding
//
//class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {
//
//    var movieList = mutableListOf<Movie>()
//
//    fun setMovies(movies: List<Movie>) {
//        this.movieList = movies.toMutableList()
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
//        return MainViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//
//        val movie = movieList[position]
//        if (ValidationUtil.validateMovie(movie)) {
//            holder.name.text = movie.name
//           // Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return movieList.size
//    }
//}

//class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {



//}