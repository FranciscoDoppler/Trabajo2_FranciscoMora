package cl.doppler.trabajo2_franciscomora;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.doppler.trabajo2_franciscomora.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng ipvg = new LatLng(-36.589764, -72.082718);
        LatLng quilamapu = new LatLng(-36.589888, -72.088848);

        mMap.addMarker(new MarkerOptions().position(ipvg).title("IPVG Chillán"));
        mMap.addMarker(new MarkerOptions().position(quilamapu).title("Centro Deportivo Quilamapu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ipvg));
    }
}