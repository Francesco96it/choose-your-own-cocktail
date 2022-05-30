package co.develhope.chooseyouowncocktail_g2.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import co.develhope.chooseyouowncocktail_g2.DrinkAction
import co.develhope.chooseyouowncocktail_g2.DrinkList

import co.develhope.chooseyouowncocktail_g2.R
import co.develhope.chooseyouowncocktail_g2.databinding.DrinkCardBinding
import co.develhope.chooseyouowncocktail_g2.model.Beer
import co.develhope.chooseyouowncocktail_g2.setImageByUrl
import java.security.AccessController.getContext
import kotlinx.coroutines.NonDisposableHandle.parent
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle
import android.content.Context
import androidx.core.content.ContextCompat


class DrinkCardAdapter(
    private val beerListForAdapter: List<Beer>,
    val action: (DrinkAction) -> Unit
) : RecyclerView.Adapter<DrinkCardAdapter.ViewHolder>() {
    private lateinit var binding: DrinkCardBinding

    inner class ViewHolder(val binding: DrinkCardBinding) : RecyclerView.ViewHolder(binding.root)
    private lateinit var context:Context





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DrinkCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context= parent.getContext()



        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int,) {

        with(receiver = holder) {
            with(beerListForAdapter[position]) {
                binding.drinkName.text = this.name
                binding.drinkShortDescription.text = this.shortDescription

                binding.drinkImage.setImageByUrl(
                    "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg",
                    60,
                    60
                )


                binding.buttonGoToDetail.setOnClickListener {
                    action(DrinkAction.GotoDetail(this.id))
                }
                // context.resources.getIdentifier("ic_fav_on", "drawable", context.packageName)


                var switch = false
                val bf = binding.drinkFavourite

                val imOn =
                    context.resources.getIdentifier("ic_fav_off", "drawable", context.packageName)
                val imOff =
                    context.resources.getIdentifier("ic_fav_on", "drawable", context.packageName)
                bf.setOnClickListener {
                    if (!switch) {
                        bf.setBackgroundResource(imOn)
                        switch = true
                    } else {
                        bf.setBackgroundResource(imOff)
                        switch = false
                    }
                }
            }


        }}



    override fun getItemCount(): Int {
        return beerListForAdapter.size
    }

}


