package com.example.admin.w3d4celeblistfrag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import java.io.Serializable;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CelebListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CelebListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebListFragment extends Fragment implements RecyclerViewAdapter.PositionClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private List<Celebrity> celeberties;

    private ToggleButton tbView;
    private int currentRV = R.layout.rv_list_item;

    private RecyclerView rv_list;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    private OnFragmentInteractionListener mListener;

    public CelebListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment CelebListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebListFragment newInstance(List<Celebrity> param1) {
        CelebListFragment fragment = new CelebListFragment();
        Bundle args = new Bundle();
        args.putSerializable (ARG_PARAM1, (Serializable) param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            celeberties = (List<Celebrity>) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final CelebListFragment tmp = this;
        tbView = view.findViewById(R.id.tbChangeView);

        rv_list = view.findViewById(R.id.rvCelebList);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(celeberties, getContext(),currentRV);
        rv_list.setAdapter(adapter);
        adapter.setAdapter2(this);
        layoutManager = new LinearLayoutManager(getContext());
        itemAnimator = new DefaultItemAnimator();
        rv_list.setLayoutManager(layoutManager);
        rv_list.setItemAnimator(itemAnimator);

        tbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentRV == R.layout.rv_list_item){
                    //rv_list = view.findViewById(R.id.rvCelebList);

                    currentRV = R.layout.rv_list_grid_item;
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(celeberties, getContext(), currentRV);
                    rv_list.setAdapter(adapter);
                    adapter.setAdapter2(tmp);
                    layoutManager = new LinearLayoutManager(getContext());
                    itemAnimator = new DefaultItemAnimator();
                    rv_list.setLayoutManager(layoutManager);
                    rv_list.setItemAnimator(itemAnimator);
                }
                else{
                    //rv_list = view.findViewById(R.id.rvCelebList);

                    currentRV = R.layout.rv_list_item;
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(celeberties, getContext(),currentRV);
                    rv_list.setAdapter(adapter);
                    adapter.setAdapter2(tmp);
                    layoutManager = new LinearLayoutManager(getContext());
                    itemAnimator = new DefaultItemAnimator();
                    rv_list.setLayoutManager(layoutManager);
                    rv_list.setItemAnimator(itemAnimator);
                }
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celeb_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void itemClicked(int position) {
        mListener.onFragmentInteraction(position);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position);
    }

}
