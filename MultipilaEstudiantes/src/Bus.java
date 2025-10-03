public class Bus {
		private String placa;
		private String color;
		private PilaPasajero pilaPas = new PilaPasajero();
		private String conductor;
		private String ruta;
		
		public Bus(String placa, String color, PilaPasajero pila, String conductor,String ruta) {
			this.setPlaca(placa);
			this.setColor(color);
			this.setPilaPas(pila);
			this.setConductor(conductor);
			this.setRuta(ruta);
		}

        public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getPlaca() {
			return placa;
		}

        public void setPlaca(String placa) {
            this.placa = placa;
        }

		public PilaPasajero getPilaPas() {
			return pilaPas;
		}

		public void setPilaPas(PilaPasajero pilaPas) {
			this.pilaPas = pilaPas;
		}

		public String getConductor() {
			return conductor;
		}

		public void setConductor(String conductor) {
			this.conductor = conductor;
		}

		public String getRuta() {
			return ruta;
		}

		public void setRuta(String ruta) {
			this.ruta = ruta;
		}
		
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("-> Bus:\n");
			s.append(String.format("Condutor: %s, Placa: %s, Color: %s , Ruta: %s\n", conductor,placa,color,ruta));
			s.append("--> Pasajeros:\n");
			s.append(pilaPas.toString());

			return s.toString();
		}
		
		public void mostrar() {
			System.out.println(toString());
		}
}
