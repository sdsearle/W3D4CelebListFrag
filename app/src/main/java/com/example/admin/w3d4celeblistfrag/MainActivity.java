package com.example.admin.w3d4celeblistfrag;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CelebListFragment.OnFragmentInteractionListener, CelebInfoFragment.OnFragmentInteractionListener {

    private static final String CELEB_LIST_FRAG_TAG = "CELEB_LIST_FRAG";
    private static final String CELEB_DISPLAY_FRAG_TAG = "CELEB_DISPLAY_FRAG";
    List<Celebrity> celeberties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celeberties = new ArrayList<>();
        celeberties.add(new Celebrity("Chris Pratt", "Gardians of the Galaxy",38,74,R.drawable.chrispratt));
        celeberties.add(new Celebrity("Orlando Bloom", "Lord of the Rings",40,71,R.drawable.orlandobloom));
        celeberties.add(new Celebrity("Emma Watson", "Beauty and the Beast",27,65,R.drawable.emmawatson));
        celeberties.add(new Celebrity("Tomomi Itano", "AKB48",26,61,R.drawable.tomomiitano));
        celeberties.add(new Celebrity("Guy-Manuel de Homem-Christo", "Daft Punk",43,67,R.drawable.daftpunk));
        celeberties.add(new Celebrity("Morgan Freeman", "The Dark Night",80,74,R.drawable.morganfreeman));

        CelebListFragment tmp = (CelebListFragment) getSupportFragmentManager().findFragmentByTag(CELEB_LIST_FRAG_TAG);
        if(tmp != null) {
            getSupportFragmentManager().beginTransaction().remove(tmp).commit();
        }

        CelebListFragment celebLF = createCelebListInfo(celeberties);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.flFragList, celebLF, CELEB_LIST_FRAG_TAG)
                .addToBackStack(null)
                .commit();
    }

    private CelebListFragment createCelebListInfo(List<Celebrity> celeberties) {
         return CelebListFragment.newInstance(celeberties);
    }

    public void OnItemClicked(int position) {
        //mListener.onFragmentInteraction(position);

    }

    @Override
    public void onFragmentInteraction(int position) {
        CelebInfoFragment tmp = (CelebInfoFragment) getSupportFragmentManager().findFragmentByTag(CELEB_DISPLAY_FRAG_TAG);
        if(tmp != null) {
            getSupportFragmentManager().beginTransaction().remove(tmp).commit();
        }
        CelebInfoFragment celebInfoFragment = createCelebListInfoFragment(position);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flFragDisplay, celebInfoFragment, CELEB_DISPLAY_FRAG_TAG)
                .addToBackStack(null)
                .commit();
    }

    private CelebInfoFragment createCelebListInfoFragment(int position) {
        Celebrity celeb = celeberties.get(position);
        return CelebInfoFragment.newInstance(celeb);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
