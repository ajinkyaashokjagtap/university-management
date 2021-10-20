DROP SEQUENCE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS decanter_exception;
DROP TABLE IF EXISTS item_group;
DROP Table IF EXISTS item_provision;
DROP Table IF EXISTS item_provision_exit;
DROP Table IF EXISTS item_supply_group;
DROP TABLE IF EXISTS provided_item_group;
DROP TABLE IF EXISTS put_carrier;
DROP TABLE IF EXISTS put_carrier;
DROP TABLE IF EXISTS real_item_group;
DROP TABLE IF EXISTS sku_variant;
DROP TABLE IF EXISTS source_carrier;
DROP TABLE IF EXISTS source_carrier_item_group;
DROP Table IF EXISTS transport_entrance;
DROP Table IF EXISTS transport_entrance_preference;

CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

CREATE TABLE decanter_exception
(
  decanterexceptionid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  carrierid uuid,
  carrierweight integer NOT NULL,
  exceptiontype integer NOT NULL,
  maximumallowedstorageweight integer NOT NULL,
  maximumallowedtransportweight integer NOT NULL,
  mhuid uuid,
  CONSTRAINT decanter_exception_pkey PRIMARY KEY (decanterexceptionid)
);

CREATE TABLE item_supply_group
(
    itemsupplygroupid uuid NOT NULL,
    createdby character varying(255) COLLATE pg_catalog."default",
    createddate timestamp without time zone,
    updatedby character varying(255) COLLATE pg_catalog."default",
    updateddate timestamp without time zone,
    processareaid uuid,
    status character varying(255) COLLATE pg_catalog."default",
    stockdemandid uuid,
    stockoverageid uuid,
    workcellclusterid uuid,
    CONSTRAINT item_supply_group_pkey PRIMARY KEY (itemsupplygroupid)
);

CREATE TABLE item_group
(
    itemgroupid uuid NOT NULL,
    createdby character varying(255) COLLATE pg_catalog."default",
    createddate timestamp without time zone,
    updatedby character varying(255) COLLATE pg_catalog."default",
    updateddate timestamp without time zone,
    decantedquantity integer NOT NULL,
    matchcode character varying(255) COLLATE pg_catalog."default",
    quantity integer NOT NULL,
    skuvariantid uuid,
    status character varying(255) COLLATE pg_catalog."default",
    stocklotid uuid,
    itemsupplygroupid uuid,
    CONSTRAINT item_group_pkey PRIMARY KEY (itemgroupid),
    CONSTRAINT fkloxl032e2rftixl1nc4v77wet FOREIGN KEY (itemsupplygroupid)
        REFERENCES item_supply_group (itemsupplygroupid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
	
CREATE TABLE item_provision
(
  itemsupplygroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  destinationprocessareaid uuid,
  sourceprocessareaid uuid,
  CONSTRAINT item_provision_pkey PRIMARY KEY (itemsupplygroupid)
);

CREATE TABLE item_provision_exit
(
 itemprovisionexitid uuid NOT NULL,
 createdby character varying(255),
 createddate timestamp without time zone,
 updatedby character varying(255),
 updateddate timestamp without time zone,
 exitid uuid,
 itemsupplygroupid uuid,
 CONSTRAINT item_provision_exit_pkey PRIMARY KEY (itemprovisionexitid)
);

CREATE TABLE item_supply_group_on_workstation
(
  itemsupplygroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  workstationbarcode character varying(255),
  workstationclusterid uuid,
  workstationstatus character varying(255),
  CONSTRAINT item_supply_group_on_workstation_pkey PRIMARY KEY (itemsupplygroupid)
);

CREATE TABLE provided_item_group
(
  provideditemgroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  itemgroupid uuid,
  itemsupplygroupid uuid,
  CONSTRAINT provided_item_group_pkey PRIMARY KEY (provideditemgroupid)
);

CREATE TABLE put_carrier
(
  destinationmhuid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  destinationmhuphysicalid character varying(255),
  itemgroupid uuid,
  mhutypereferenceid uuid,
  processareaid uuid,
  quantity integer NOT NULL,
  status character varying(255),
  workcellclusterid uuid,
  CONSTRAINT put_carrier_pkey PRIMARY KEY (destinationmhuid)
);

CREATE TABLE real_item_group
(
  itemgroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  destinationmhuid uuid,
  processareaid uuid,
  status character varying(255),
  workcellclusterid uuid,
  CONSTRAINT real_item_group_pkey PRIMARY KEY (itemgroupid)
);

CREATE TABLE sku_variant
(
  skuvariantid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  description character varying(255),
  height double precision,
  imagelink character varying(255),
  length double precision,
  skuid uuid,
  weight double precision,
  width double precision,
  CONSTRAINT sku_variant_pkey PRIMARY KEY (skuvariantid)
);

CREATE TABLE source_carrier
(
  mhuid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  itemsupplygroupid uuid,
  mhuphysicalid character varying(255),
  status character varying(255),
  carrierid uuid,
  CONSTRAINT source_carrier_pkey PRIMARY KEY (mhuid)
);

CREATE TABLE source_carrier_item_group
(
  mhuitemgroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  itemgroupid uuid,
  mhuid uuid,
  CONSTRAINT source_carrier_item_group_pkey PRIMARY KEY (mhuitemgroupid)
);

CREATE TABLE transport_entrance
(
  transportentranceid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  entranceid uuid,
  supplygroupid uuid,
  CONSTRAINT transport_entrance_pkey PRIMARY KEY (transportentranceid)
);

CREATE TABLE transport_entrance_preference
(
  supplygroupid uuid NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  updatedby character varying(255),
  updateddate timestamp without time zone,
  destinationprocessareaid uuid,
  sourceprocessareaid uuid,
  CONSTRAINT transport_entrance_preference_pkey PRIMARY KEY (supplygroupid)
);