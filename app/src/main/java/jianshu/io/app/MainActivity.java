package jianshu.io.app;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends FinalActivity {

  @ViewInject(id = R.id.left_drawer)
  ListView mDrawerList;
  @ViewInject(id = R.id.drawer_layout)
  DrawerLayout mDrawerLayout;
  private CharSequence mTitle;
  private CharSequence mDrawerTitle;
  private ActionBarDrawerToggle mDrawerToggle;
  private String[] mTitles;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTitles = getResources().getStringArray(R.array.drawer_titles);
    mTitle = mDrawerTitle = getTitle();
    mDrawerList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    mDrawerList.setAdapter(new ArrayAdapter<String>(this,
        R.layout.drawer_item,
        mTitles));
    mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);

    mDrawerToggle = new ActionBarDrawerToggle(
        this,                  /* host Activity */
        mDrawerLayout,         /* DrawerLayout object */
        R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
        R.string.drawer_open,  /* "open drawer" description for accessibility */
        R.string.drawer_close  /* "close drawer" description for accessibility */
    ) {
      public void onDrawerClosed(View view) {
        getActionBar().setTitle(mTitle);
        invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
      }

      public void onDrawerOpened(View drawerView) {
        getActionBar().setTitle(mDrawerTitle);
        invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
      }
    };

    mDrawerLayout.setDrawerListener(mDrawerToggle);

    if (savedInstanceState == null) {
      selectItem(0);
    }
  }

  private void selectItem(int position) {
    Fragment fragment = getRelatedFragment(position);
    FragmentManager fragmentManager = getFragmentManager();
    if (fragment instanceof DialogFragment) {
      ((DialogFragment) fragment).show(fragmentManager, "not ready");
    } else {
      fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    mDrawerList.setItemChecked(position, true);
    setTitle(mTitles[position]);
    mDrawerLayout.closeDrawer(mDrawerList);
  }


  private Fragment getRelatedFragment(int position) {
    switch (position) {
      case 0:
        return RecommendationFragment.newInstance();
      default:
        return NotReadyFragment.newInstance();
    }
  }

  @Override
  public void setTitle(CharSequence title) {
    mTitle = title;
    getActionBar().setTitle(mTitle);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    // If the nav drawer is open, hide action items related to the content view
    boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // The action bar home/up action should open or close the drawer.
    // ActionBarDrawerToggle will take care of this.
    if (mDrawerToggle.onOptionsItemSelected(item)) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // Sync the toggle state after onRestoreInstanceState has occurred.
    mDrawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    // Pass any configuration change to the drawer toggls
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  class DrawerItemClickListener implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
      selectItem(i);
    }
  }
}
