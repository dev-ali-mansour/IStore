package dev.alimansour.istore.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.alimansour.istore.R
import dev.alimansour.istore.daomain.model.Product
import kotlinx.android.synthetic.main.popularitemlist.view.*


class CategoryAdapter (context: Context) :
        RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
        private val layoutInflater = LayoutInflater.from(context)


        private var items:List<Product> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = layoutInflater.inflate(R.layout.popularitemlist, parent, false)
            return ViewHolder(itemView)
        }

    fun submitList(product: List<Product>){
        items = product
    }
        override fun getItemCount() = items.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            when(holder){
                is ViewHolder ->{
                    holder.bind(items[position])

                }
            }


                }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var img: ImageView = itemView.product_img
            var name: TextView = itemView.product_name
            var desc: TextView = itemView.product_description
            var price= itemView.product_price

            fun bind(product: Product){

                name.text = product.title
                desc.text = product.description
                price.text = product.price.toString()

                val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(product.image)
                    .into(img)

            }

            init {
                itemView?.setOnClickListener {

                }
            }
        }
    }

