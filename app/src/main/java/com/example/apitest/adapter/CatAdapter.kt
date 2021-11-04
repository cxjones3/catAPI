package com.example.apitest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.databinding.ItemImageBinding
import com.example.apitest.model.Breed
import com.bumptech.glide.Glide

class CatAdapter: RecyclerView.Adapter<CatAdapter.CatViewHolder>(){

    private val urls = mutableListOf<Breed>()



    class CatViewHolder(private val binding : ItemImageBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun loadImage(url: Breed) = with(binding){
              //  ivImage.
                val imageUrl= url.image.url
                Glide.with(ivImage).load(imageUrl).into(ivImage)
            }

        companion object{
            fun getInstance(parent: ViewGroup) : CatViewHolder{
              val binding =   ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,false
                )
              return CatViewHolder(binding)
            }
        }

    }

    fun updateUrls(urls: List<Breed>){
        val size = this.urls.size
        this.urls.clear()
        notifyItemRangeRemoved(0,size)

        this.urls.addAll(urls)
        notifyItemRangeInserted(0, urls.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.loadImage(urls[position])
    }

    override fun getItemCount(): Int {
        return urls.size
    }
}