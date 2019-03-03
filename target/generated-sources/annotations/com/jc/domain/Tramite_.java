package com.jc.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tramite.class)
public abstract class Tramite_ {

	public static volatile SingularAttribute<Tramite, Integer> idTramite;
	public static volatile SingularAttribute<Tramite, Timestamp> fechaCreacion;
	public static volatile SingularAttribute<Tramite, String> tipoTramite;

}

