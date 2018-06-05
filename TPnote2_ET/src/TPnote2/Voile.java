package TPnote2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="voile")
public class Voile extends Bateau {
	
	private double surfaceVoile;

	public double getSurfaceVoile() {
		return surfaceVoile;
	}

	public void setSurfaceVoile(double surfaceVoile) {
		this.surfaceVoile = surfaceVoile;
	}
}
