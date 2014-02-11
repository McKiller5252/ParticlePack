package me.McKiller5252.particlepack.particleeffects.data;

public final class FieldPair {
	private final String name;
	private final Object value;
 
	public FieldPair(String name, Object value) {
		this.name = name;
		this.value = value;
	}
 
	public String getName() {
		return this.name;
	}
 
	public Object getValue() {
		return this.value;
	}
}
