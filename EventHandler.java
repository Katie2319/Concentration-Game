class ButtonClickHandler implements EventHandler<ActionEvent> {

   @Override
   
   public void handle(ActionEvent event) {

   for (int i=0;i<4;i++){ 
  
       if(event.getSource().equals(buttons[i])){
          buttons[i] = makeButton(new Image("file:o.png"));
          grid.add(buttons[i],i,0);

}

}
