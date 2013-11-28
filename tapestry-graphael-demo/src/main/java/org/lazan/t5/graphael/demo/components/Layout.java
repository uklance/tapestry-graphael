package org.lazan.t5.graphael.demo.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.alerts.AlertStorage;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

@Import(stylesheet="context:bootstrap/css/bootstrap.css")
public class Layout {
	private static final MenuGroup[] MENU_GROUPS = {
		new MenuGroup("Charts",
			new MenuItem("Pie Chart", "PieChartDemo")
		)
	};
	
	@SessionState(create=false)
	private AlertStorage alertsStorage;
	
	@Inject
	private ComponentResources resources;
	
	@Property
	private MenuGroup menuGroup;
	
	@Property
	private MenuItem menuItem;
	
	public boolean isAlerts() {
		return (alertsStorage != null && !alertsStorage.getAlerts().isEmpty());
	}
	
	public String getTitle() {
		return "TODO: Title";
	}
	
	public String getPageClass() {
		return resources.getPageName().equalsIgnoreCase(menuItem.page) ? "active" : null;
	}
	
	public MenuGroup[] getMenuGroups() {
		return MENU_GROUPS;
	}
	
	public static class MenuGroup {
		public String label;
		public MenuItem[] items;

		MenuGroup(String label, MenuItem... items) {
			this.label = label;
			this.items = items;
		}
	}
	
	public static class MenuItem {
		public String label;
		public String page;
		
		MenuItem(String label, String page) {
			super();
			this.label = label;
			this.page = page;
		}
	}
}
