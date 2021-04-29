package com.suek.nyamnyam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


// 1. Food Tab

public class FragmentTab1Food extends Fragment {

    TextView tvShareYourCook;
    CircleImageView civProfile;

    // food Category
    ArrayList<Item> items= new ArrayList<>();
    RecyclerCategoryAdapter adapter;
    RecyclerView recyclerView;

    // Recommended Recipe
    ArrayList<RecommendedItems> recommendedItems= new ArrayList<>();
    RecommendedAdapter recommendedAdapter;
    RecyclerView recommendedRecyclerView;

    ImageView iv;

    CalendarView calendarView;
    ArrayList<CalendarItem> calendarItems= new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.tab1_food_fragment, container, false);


        //메인화면(tap1 food)에 있는 Food Category Recyclerview items
        items.add(new Item("https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg", "VEGAN", "채식",
                "It's not a secret that Korea is well known as meat paradise for those meat lovers. But that doesn't mean that vegetarians can't have Korean food! We'll share general dishes how to enjoy Korean food like a pure vegetarian and you will soon fall in love.",
                "https://images.happycow.net/venues/1024/14/53/hcmp145394_726578.jpeg"));
        items.add(new Item("https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg", "SOUP", "찌개",
                "Soup is called as Jjigae or Guk. Jjigae is basically contains more solid ingredients such as vegetables, meat or seafood. It's common practice for families to share a pot of Jjigae, whilst Guk is prepared for each person in a bowl as a side dish.",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/04/21/84d2afaa37d7d004c66bfb32817744a11.jpg"));
        items.add(new Item("https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg", "RICE", "밥",
                "Rice is called as Ssal before it's cooked and Bap after it's cooked. Rice is the basics of Korean food and harmonized with various side dishes. Koreans usually cook rice itself and also enjoy having with other grains in it.",
                "https://www.nongsaro.go.kr/ps/img/interabang/num207/headerImg.jpg"));
        items.add(new Item("https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg", "MEAT", "고기",
                "Gogi is what we call for meat. Somewhat Korean BBQ is well known as a staple but there are more to offer amazing meat dishes that you've ever heard. It will not only satisfy your tongue, but also your gastric from healthy and beneficial ingredients.",
                "https://m.handokmall.kr/web/product/big/201901/b76a02afec251e63c5f3013f3bd461b5.jpg"));
        items.add(new Item("https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg", "NOODLE", "면",
                "",
                "https://image.auction.co.kr/itemimage/11/a9/e0/11a9e0eb26.jpg"));
        items.add(new Item("https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg", "VEGGIE", "야채",
                "",
                "https://i.ytimg.com/vi/ybCOfiNp01M/maxresdefault.jpg"));
        items.add(new Item("https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg", "DESSERT", "디저트",
                "",
                "https://travelright.com/wp-content/uploads/2019/12/Korean-Patbingsu.jpg"));
        items.add(new Item("https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg", "PORRIDGE", "죽",
                "",
                "https://files.bonif.co.kr/upload/cmdt/BF101_pic_qhO61yeq.jpg"));
        items.add(new Item("https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg", "SPECIAL", "스페셜",
                "",
                "https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2019/05/17/965cc82059734e0f8d3159e99b4af981_%E1%84%81%E1%85%A9%E1%86%BE%E1%84%89%E1%85%A9%E1%86%BC%E1%84%91%E1%85%A7%E1%86%AB-1030x773.jpg"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg", "PANCAKE", "부침개",
                "",
                "https://imagescdn.gettyimagesbank.com/500/201708/jv10928958.jpg"));
        items.add(new Item("https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg", "BUNSIK", "분식",
                "",
                "https://imagescdn.gettyimagesbank.com/500/201811/a11203592.jpg"));

        recyclerView= view.findViewById(R.id.recycler_food_category);
        adapter= new RecyclerCategoryAdapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);







        //Food Tab Fragment 에서 보여지는 추천레시피 recyclerview 아이템
        recommendedItems.add(new RecommendedItems("https://www.maangchi.com/wp-content/uploads/2019/11/oxtail-soup-insta-650x650.jpg", "Sokkoritang","Oxtail Soup" ,"소꼬리탕",
                "For the oxtail broth:\n" +  "\n"+
                "2½ pounds to 3 pounds sliced oxtail\n" +
                "1½ pounds Korean radish (or daikon), peeled and cut in half lengthwise, if you use daikon, you don’t have to cut in half lengthwise\n" +
                "4 garlic cloves, minced\n" +
                "kosher salt\n" +
                "For seasoning paste (optional):\n" + "\n"+
                "1 garlic clove, minced\n" +
                "1 tablespoon soy sauce\n" +
                "2 tablespoons gochu-garu (Korean hot pepper flakes)\n" +
                "1 tablespoon toasted sesame oil\n" +
                "For serving:\n" + "\n"+
                "1 daepa (large green onion), or 4 to 6 green onions, chopped\n" +
                "kosher salt\n" +
                "ground black pepper", "Make the oxtail broth:\n" +
                "\n" +
                "Trim away and discard any excess solid fat attached to the oxtail pieces. Place the oxtails in a large bowl and rinse a few times with cold water to remove any bone fragments. Cover with cold water and soak at least for 3 hours up to overnight, changing the water a few times."
                +"Bring 10 cups water to a boil in a heavy and large pot over medium high heat. Add the oxtails and blanch for 12 minutes. Foam and bubbles will float on the surface and the water will be brownish. Drain and rinse the bones thoroughly."
                +"Wash out the pot. Add the oxtail bones, radish, garlic, 2 teaspoons salt, and 16 cups water.\n" + "\n"+
                "Cover and cook over medium high heat for 20 to 25 minutes until it comes to a rolling boil."
                +"Turn down the heat to between medium and medium low.\n" +
                "Simmer for about 2 hours until the radish is fully cooked and the meat is very tender but still attached to the bones.\n" +
                "Remove the pot from the heat. Transfer the bones and radish to a bowl and let cool. Put the bones in an airtight container and refrigerate."
                +"Cut the radish into about ½ inch thick bite-size pieces. Put the radish in an airtight container and refrigerate."
                +"Let the broth cool down to room temperature. Refrigerate for several hours or overnight, until the fat floats to the top and solidifies. If it’s cold outside, you can let it cool down on your porch, windowsill, or balcony.\n" +
                "Once the broth has cooled and the fat solidified on top, remove the fat with a skimmer and discard. You should be left with 9 to 12 cups of bone broth."
                +"Make the seasoning paste:\n" +
                "\n" +
                "Combine the soy sauce, toasted sesame oil, garlic, and hot pepper flakes in a bowl and mix well. Cover and refrigerate."
                +"Serve in a soup bowl:\n" +
                "Add the oxtail bones to the pot of broth and bring to a boil over high heat.\n" +
                "For each serving, put about ¼ cup chopped daepa in a large ceramic bowl. Top with 6 or 7 pieces of radish. Add a few bones and ladle the hot broth over top. Serve with the seasoning paste (if using), and set bowls of salt and ground black pepper on the table. Serve with rice and kkakdugi or any fermented kimchi. Everyone can add salt and pepper to their taste."
                ,"from Maangchi.com"));
        recommendedItems.add(new RecommendedItems("https://www.maangchi.com/wp-content/uploads/2020/02/kimchipancake-620x349.jpg", "Kimchijeon","Kimchi Pancake" ,"김치전",
                "½ pound well-fermented napa cabbage kimchi, chopped into small pieces, plus 2 tablespoons of the brine\n" +
                        "3 scallions, chopped\n" +
                        "½ teaspoon sugar\n" +
                        "½ cup all-purpose flour\n" +
                        "½ cup water\n" +
                        "4 tablespoons vegetable oil",
                "1. Combine the kimchi, kimchi brine, scallions, sugar, flour, and water in a medium bowl and mix well with a spoon.\n" +
                        "2. Heat a 12-inch nonstick skillet over medium heat. (If you don’t have a 12-inch skillet, use a smaller skillet to make 2 pancakes.)\n" +
                        "3. Add 2 tablespoons of the vegetable oil and swirl to coat the bottom of the pan.\n" +
                        "4. Pour the batter into the pan and spread it with the back of a spoon or a spatula to make a large circle.\n"+
                "5. Cook until the bottom is golden brown and crisp, 3 to 5 minutes.\n" +
                        "6. Carefully turn the pancake over. Drizzle the remaining 2 tablespoons oil around the edges of the skillet, then lift the pancake with a thin spatula to allow the oil to run underneath and tilt the pan to spread it evenly.\n" +
                        "7. Cook until the bottom of the pancake is light golden brown and crisp, 3 to 5 minutes.\n" +
                        "8. Flip it one more time and cook for another minute.\n" +
                        "9. Slide onto a large serving platter and serve immediately.","from Maangchi.com"));
        recommendedItems.add(new RecommendedItems("https://www.maangchi.com/wp-content/uploads/2008/09/maeuntang-1-650x413.jpg", "Maeuntang","Spicy Fish Stew" ,"매운탕",
                "2½ pounds cleaned whole fish (black sea bass, cod, pollock, flounder, fluke), cut into 2 inch pieces\n" +
                        "8 cups water\n" +
                        "1 pound Korean radish (or daikon) sliced into ⅛ inch thin bite sized pieces\n" +
                        "7-8 large dried anchovies, with heads and guts removed and placed in a stock pouch (or soup strainer, or tied up in cheesecloth)\n" +
                        "1 dae-pa (or 4 to 5 green onions), sliced diagonally\n" +
                        "1 large green chili pepper, sliced\n" +
                        "1 red chili pepper, optional but if you use, sliced diagonally\n" +
                        "4-5 sprigs of chrysanthemum greens (substitute with a few basil sprigs)\n"+
                        "For the seasoning paste:\n" +
                        "\n" +
                        "½ cup hot pepper flakes\n" +
                        "10 garlic cloves, minced\n" +
                        "2 tablespoons Korean fermented bean paste (doenjang)\n" +
                        "1 tablespoon Korean hot pepper paste (gochujang)\n" +
                        "1 tablespoon soy sauce\n" +
                        "2 tablespoons fish sauce\n" +
                        "½ teaspoon ground black pepper\n" +
                        "3 tablespoons mirim (or soju)",
                "Make seasoning paste:\n" +
                        "\n" +
                        "Combine the seasoning paste ingredients in a bowl.\n" +
                        "Mix it well with a spoon. Set aside.\n"+
                        "\n" +"Make maeuntang:\n" +
                        "\n" +
                        "Combine the radish, dried anchovies, and 8 cups of water in a large pot.\n" +
                        "Cover and cook for 20 minutes over medium high heat until the radish turns a little soft.\n" +
                        "Add the fish and about half of the seasoning paste.\n"+"Gently stir the stew a few times with a wooden spoon and cook for about 3 to 5 minutes.\n" +
                        "Turn off the heat and add the chrysanthemum greens and red chili peppers.\n"+
                "Serve:\n" +
                        "\n" +
                        "Serve with rice, kimchi, and a few other side dishes, if you have them.\n" +
                        "You can put the stew in the middle of the table, with a ladle. Provide bowls for each person and ladle some of the stew into each bowl.\n" +
                        "Provide an empty bowl for bones. As people eat the fish they can discard the bones there.","from Maangchi"));
        recommendedItems.add(new RecommendedItems("https://www.maangchi.com/wp-content/uploads/2018/03/spicy-steamed-eggs.jpg", "Gyeranjjim","Steamed Eggs" ,"계란찜",
                "4 large eggs\n" +
                "½ cup chicken broth\n" +
                "1 tablespoon and 1 teaspoon soy sauce\n" +
                "1 tablespoon and ½ teaspoon hot pepper flakes (gochu-garu)\n" +
                "1 tablespoon toasted sesame seeds, ground\n" +
                "2 green onions, chopped\n" +
                "1 or 2 teaspoons toasted sesame oil",
                "1. Put ¼ cup chicken broth into a 2½ cup Korean earthenware bowl (aka ttukbaegi 뚝배기) or a small and heavy saucepan.\n" +
                        "2. Make sure it fits your stove element properly, not too big or too small. Don’t turn on the stove yet!\n" +
                        "3. Combine the eggs, soy sauce, 1 tablespoon hot pepper flakes, and ground sesame seeds in a bowl. Beat the mixture with a fork 50 times, or about 1 minute.\n"+
                        "4. Bring the chicken broth in the earthenware bowl to a boil over medium high heat. Korean ttukbaegi heat up slow, in 2 or 3 minutes, but a stainless steel saucepan will heat up faster, in about a minute.\n"+
                        "5. Turn down the heat to medium low. Slowly pour the egg mixture into the bowl a little by little, stirring with the fork as you go. The egg mixture will fill about 80 percent of the bowl.\n"+
                        "6. Stir several more times and cover with any dome shaped heat-resistant lid or bowl, so that the mixture has room to expand while it’s being cooked.\n"+
                        "7. Simmer for 10 minutes until steam comes out of the gap between the bowl and the lid.\n" +
                        "Uncover and sprinkle with green onion, and ½ teaspoon hot pepper flakes. Drizzle some toasted sesame oil over top and serve right away with rice.\n"
                ,"from Maangchi.com"));
        recommendedItems.add(new RecommendedItems("https://i.pinimg.com/originals/91/e1/26/91e12660187a7d72ea9dafe452b1f8e0.jpg", "Dakbokkeumtang","Braised Chicken Breasts" ,"닭볶음탕",
                "Serves 2 to 3\n" +
                        "\n" +
                        "1 pound chicken breasts (about 2 large chicken breasts)\n" +
                        "¼ cup milk\n" +
                        "½ teaspoon kosher salt\n" +
                        "1 small apple, peeled, cored, and sliced thinly (about 1 cup)\n" +
                        "8 ounces potato, peeled and cut into 1/2 to 1 inch thick bite sized chunks\n" +
                        "1 medium onion (6 ounces), sliced\n" +
                        "1 green chili pepper, chopped\n" +
                        "2 green onions, cut into 1 inch long\n"+
                "For seasoning paste:\n" +
                        "\n" +
                        "2 tablespoons soy sauce\n" +
                        "1 tablespoon hot pepper flakes\n" +
                        "2 tablespoons hot pepper paste\n" +
                        "4 garlic cloves, minced\n" +
                        "1 teaspoon peeled ginger, minced\n" +
                        "½ teaspoon ground black pepper",
                "Prepare the chicken:\n" +
                        "\n" +
                        "Cut each breast crosswise into 2½ inch chunks. You will get about 4 pieces.\n" +
                        "Make 1 inch deep slits into each chunk ½ inch apart.  Transfer them all to a medium bowl and sprinkle the salt over top and in the slits evenly. Add the milk and gently mix to marinate. Cover and refrigerate for at least 30 minutes and up to 2 hours.\n"+
                "Meanwhile make the seasoning paste:\n" +
                        "\n" +
                        "Combine all the ingredients in a small bowl and mix well with a spoon.\n"+
                "Cook dakbokkeumtang:\n" +
                        "\n" +
                        "Put a piece of chicken on the cutting board, the slit side up. Use your hands to push a few apple slices into each slit.\n" +
                        "Then transfer it to a pan or pot. I use a shallow 9½ inch pan that’s 2½ inches deep.\n" +
                        "Repeat with the rest of chicken and the apple slices. If you have some leftover apple slices, put them anywhere in the pan.\n"+
                "Add the seasoning paste over the top of the chicken and add 2½ cups water. Cover and cook for 15 minutes over medium high heat.\n"+
                "Add the potato, onion, and green chili pepper. Gently stir the chicken and vegetables with a wooden spoon. Cover, reduce the heat to medium, and cook for another 15 minutes. If it boils over or the water is boiled down, add more water and crack the lid open a little. \n"+
                "Open and add the green onions. Turn up the heat to medium high and stir for 1 minute until vigorously bubbling.\n"+
                "Remove from the heat\n"+
                "Serve:\n" +
                        "\n" +
                        "Transfer to the table and serve right away in the pan with rice, kimchi, and a few more side dishes. If you cook this in a large pot, you can use a ladle and transfer to a plate and serve.","from Maanchi.com"));


        recommendedRecyclerView= view.findViewById(R.id.recycler_recommended);
        recommendedAdapter= new RecommendedAdapter(getActivity(), recommendedItems);
        recommendedRecyclerView.setAdapter(recommendedAdapter);


        iv= view.findViewById(R.id.iv_food_culture);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), FoodCultureActivity.class);
                //intent.putExtra 해주기
                startActivity(intent);
            }
        });





        //프로필사진 (로그인정보) 불러들여오기
        civProfile= view.findViewById(R.id.civ_profile);
        SharedPreferences pref= this.getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);
        String profileUrl= pref.getString("profileUrl","");
        Glide.with(getContext()).load(profileUrl).into(civProfile);


        tvShareYourCook= view.findViewById(R.id.tv_share_your_cook);
        tvShareYourCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), EditPostActivity.class);
                startActivity(intent);
            }
        });















        //다시

        //달력 날짜를 클릭하면 뜨는 다이얼로그
        calendarView= view.findViewById(R.id.calendarview);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                //String date=year+"-"+(month+1)+"-"+dayOfMonth;
                String date= String.format("%4d-%02d-%02d", year, (month+1), dayOfMonth);
                Log.i("tag", date);
                loadData(date);

            }
        });

        return view;




    }//onCreateView



    void loadData(String date){
        Retrofit retrofit= RetrofitHelper_Calendar.getInstance();
        RetrofitService_Calendar retrofitService= retrofit.create(RetrofitService_Calendar.class);
        Call<ArrayList<CalendarItem>> call= retrofitService.loadDataFromCalendar(date);
        call.enqueue(new Callback<ArrayList<CalendarItem>>() {
            @Override
            public void onResponse(Call<ArrayList<CalendarItem>> call, Response<ArrayList<CalendarItem>> response) {
                if(response.isSuccessful()){
                    //Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    ArrayList<CalendarItem> items= response.body();
                    //Toast.makeText(getContext(), items.size()+"", Toast.LENGTH_SHORT).show();

                    if(items.size()!=0){

                        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                        View view1= LayoutInflater.from(getActivity()).inflate(R.layout.calendar_dialog, null);   //붙일 부모가 없으니 null


                        CalendarItem item= items.get(0);
                        TextView tvTitle= view1.findViewById(R.id.tv_title);
                        TextView tvDate= view1.findViewById(R.id.tv_date);
                        TextView tvMsg= view1.findViewById(R.id.tv_msg);
                        ImageView iv= view1.findViewById(R.id.iv);

                        tvTitle.setText(item.title);
                        tvDate.setText(item.date);
                        tvMsg.setText(item.msg);
                        String imgUri= "http://suhyun2963.dothome.co.kr/CalendarDialog/"+item.file;
                        Glide.with(view1).load(imgUri).into(iv);


                        //Log.i("tag",  )
                        //Glide.with(view1).load()




                        builder.setView(view1);
                        AlertDialog alertDialog= builder.create();
                        alertDialog.show();

                    }


                }
            }

            @Override
            public void onFailure(Call<ArrayList<CalendarItem>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }









}
