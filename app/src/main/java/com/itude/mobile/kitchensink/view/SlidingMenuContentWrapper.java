package com.itude.mobile.kitchensink.view;

import android.content.res.Resources;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

import com.itude.mobile.android.util.AssertUtil;
import com.itude.mobile.android.util.ScreenUtil;
import com.itude.mobile.kitchensink.R;
import com.itude.mobile.mobbl.core.controller.MBDialogController;
import com.itude.mobile.mobbl.core.controller.MBDialogManager;
import com.itude.mobile.mobbl.core.controller.MBDialogManager.MBDialogChangeListener;
import com.itude.mobile.mobbl.core.controller.MBHomeButtonHandler;
import com.itude.mobile.mobbl.core.controller.MBViewManager;
import com.itude.mobile.mobbl.core.util.MBScreenConstants;
import com.itude.mobile.mobbl.core.view.builders.MBContentViewWrapper;
import com.itude.mobile.mobbl.core.view.builders.dialog.MenuDialogDecorator;

public class SlidingMenuContentWrapper implements MBContentViewWrapper {

    public class SlidingMenuHomeButtonHandler implements MBHomeButtonHandler {

        private final DrawerLayout _drawerLayout;

        public SlidingMenuHomeButtonHandler(DrawerLayout drawerLayout) {
            _drawerLayout = drawerLayout;
        }

        @Override
        public void handleButton() {
            MBViewManager viewManager = MBViewManager.getInstance();

            if (viewManager == null) {
                return;
            }

            if (_drawerLayout.isDrawerVisible(GravityCompat.START))
                _drawerLayout.closeDrawer(GravityCompat.START);
            else _drawerLayout.openDrawer(GravityCompat.START);

        }

    }

    @Override
    public View buildContentView(MBViewManager viewManager, View container) {

        // creates the drawer layout (duh...)
        final DrawerLayout wrapper = new DrawerLayout(viewManager);

        // add the main container to the layout
        LayoutParams layout = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        wrapper.addView(container, layout);

        // grab the dialog containing the menu
        MBDialogManager dialogManager = MBViewManager.getInstance().getDialogManager();
        MBDialogController menu = MenuDialogDecorator.getMenuDialog();

        AssertUtil.notNull("menu", menu);

        // needed to fill the menu; can probably also be done when the menu actually opens
        menu.activateWithoutSwitching();

        // add a background to the menu, since it defaults to being transparent; looks quite cool, but is probably not what you want ;)
        int color = viewManager.getResources().getColor(android.R.color.background_light);
        View menuView = menu.getMainContainer();
        menuView.setBackgroundColor(color);

        // finally, add the menu to the drawerlayout
        LayoutParams drawerLayout = new LayoutParams(ScreenUtil.convertDimensionPixelsToPixels(viewManager, 240), LayoutParams.MATCH_PARENT, GravityCompat.START);
        wrapper.addView(menuView, drawerLayout);

        // allow the menu to open when the home button in the action bar is pressed
        viewManager.setHomeButtonHandler(new SlidingMenuHomeButtonHandler(wrapper));

        // close the menu when a new dialog is activated (e.g. by switching to it from the menu ;))
        dialogManager.addDialogChangeListener(new MBDialogChangeListener() {

            @Override
            public void onDialogSelected(String name) {
                wrapper.closeDrawers();
            }
        });

        viewManager.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewManager.getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewManager.getSupportActionBar().setHomeButtonEnabled(true);
        viewManager.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        return wrapper;
    }
}
