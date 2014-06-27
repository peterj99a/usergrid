package org.apache.usergrid.chop.webapp.view.module;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.apache.usergrid.chop.api.Module;
import org.apache.usergrid.chop.webapp.dao.ModuleDao;
import org.apache.usergrid.chop.webapp.service.InjectorFactory;

import java.util.List;


public class ModuleLayout extends VerticalLayout{

    private final ModuleSelectListener listener;

    public ModuleLayout ( ModuleSelectListener listener ){
        this.listener = listener;
        Table userTable = addTable();
        addComponent( userTable );
        setComponentAlignment( userTable, Alignment.MIDDLE_CENTER );
    }


    public Table addTable( ){
        Table table = new Table( " \n " );
        table.setHeight( "500px" );
        table.setWidth( "700px" );

        table.addContainerProperty( "Group", Label.class, null );
        table.addContainerProperty( "Artifact", Label.class, null );
        table.addContainerProperty( "Version", Label.class, null );
        table.addContainerProperty( "Results", Button.class, null );

        loadData( table );
        return table;
    }

    private void onItemClick( String id) {
        listener.onModuleSelect( id );
    }

    public void loadData( Table userTable ){
        ModuleDao moduleDao = InjectorFactory.getInstance( ModuleDao.class );
        List<Module> modules = moduleDao.getAll();
        for( final Module module : modules ) {
            Label groupLabel = new Label( module.getGroupId( ) );
            Label artifactLabel = new Label( module.getArtifactId( ) );
            Label versionLabel = new Label( module.getVersion( ) );

            Button detailsField = new Button( "show details" );
            detailsField.addStyleName( "link" );
            detailsField.addClickListener( new Button.ClickListener( ) {
                @Override
                public void buttonClick( Button.ClickEvent event ) {
                    onItemClick( module.getId() );
                }
            } );
            userTable.addItem( new Object[]{ groupLabel, artifactLabel, versionLabel, detailsField }, module.getId( ) );
        }
    }
}