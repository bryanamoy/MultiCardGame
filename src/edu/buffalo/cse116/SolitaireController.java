
	private MainMenu gui;
	private SolitaireView view = new SolitaireView();
	private BakersDozen bd;
	private Freecell fc;
	private DropShadow ds = new DropShadow(20, Color.BLACK);
	public Node whichClick;
	
	public void selected(StackPane s){
		HashMap<Card,ImageView> images = view.getCardImages();
		EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				s.setEffect(ds);
			}
		};
		EventHandler<MouseEvent> mouseReleased = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				s.setEffect(null);
			}
		};
		s.setOnMousePressed(mouseEntered);
		s.setOnMouseReleased(mouseReleased);
	}
	

	
	
	
	
	




