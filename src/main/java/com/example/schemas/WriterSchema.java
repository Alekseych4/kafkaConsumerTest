/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemas;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class WriterSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 511878136902009151L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WriterSchema\",\"namespace\":\"com.example.schemas\",\"fields\":[{\"name\":\"nickname\",\"type\":\"string\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"surname\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"rating\",\"type\":[\"null\",\"double\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WriterSchema> ENCODER =
      new BinaryMessageEncoder<WriterSchema>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WriterSchema> DECODER =
      new BinaryMessageDecoder<WriterSchema>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<WriterSchema> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<WriterSchema> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<WriterSchema> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<WriterSchema>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this WriterSchema to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a WriterSchema from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a WriterSchema instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static WriterSchema fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence nickname;
  private java.lang.CharSequence name;
  private java.lang.CharSequence surname;
  private java.lang.Double rating;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WriterSchema() {}

  /**
   * All-args constructor.
   * @param nickname The new value for nickname
   * @param name The new value for name
   * @param surname The new value for surname
   * @param rating The new value for rating
   */
  public WriterSchema(java.lang.CharSequence nickname, java.lang.CharSequence name, java.lang.CharSequence surname, java.lang.Double rating) {
    this.nickname = nickname;
    this.name = name;
    this.surname = surname;
    this.rating = rating;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return nickname;
    case 1: return name;
    case 2: return surname;
    case 3: return rating;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: nickname = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: surname = (java.lang.CharSequence)value$; break;
    case 3: rating = (java.lang.Double)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return The value of the 'nickname' field.
   */
  public java.lang.CharSequence getNickname() {
    return nickname;
  }


  /**
   * Sets the value of the 'nickname' field.
   * @param value the value to set.
   */
  public void setNickname(java.lang.CharSequence value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'surname' field.
   * @return The value of the 'surname' field.
   */
  public java.lang.CharSequence getSurname() {
    return surname;
  }


  /**
   * Sets the value of the 'surname' field.
   * @param value the value to set.
   */
  public void setSurname(java.lang.CharSequence value) {
    this.surname = value;
  }

  /**
   * Gets the value of the 'rating' field.
   * @return The value of the 'rating' field.
   */
  public java.lang.Double getRating() {
    return rating;
  }


  /**
   * Sets the value of the 'rating' field.
   * @param value the value to set.
   */
  public void setRating(java.lang.Double value) {
    this.rating = value;
  }

  /**
   * Creates a new WriterSchema RecordBuilder.
   * @return A new WriterSchema RecordBuilder
   */
  public static com.example.schemas.WriterSchema.Builder newBuilder() {
    return new com.example.schemas.WriterSchema.Builder();
  }

  /**
   * Creates a new WriterSchema RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WriterSchema RecordBuilder
   */
  public static com.example.schemas.WriterSchema.Builder newBuilder(com.example.schemas.WriterSchema.Builder other) {
    if (other == null) {
      return new com.example.schemas.WriterSchema.Builder();
    } else {
      return new com.example.schemas.WriterSchema.Builder(other);
    }
  }

  /**
   * Creates a new WriterSchema RecordBuilder by copying an existing WriterSchema instance.
   * @param other The existing instance to copy.
   * @return A new WriterSchema RecordBuilder
   */
  public static com.example.schemas.WriterSchema.Builder newBuilder(com.example.schemas.WriterSchema other) {
    if (other == null) {
      return new com.example.schemas.WriterSchema.Builder();
    } else {
      return new com.example.schemas.WriterSchema.Builder(other);
    }
  }

  /**
   * RecordBuilder for WriterSchema instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WriterSchema>
    implements org.apache.avro.data.RecordBuilder<WriterSchema> {

    private java.lang.CharSequence nickname;
    private java.lang.CharSequence name;
    private java.lang.CharSequence surname;
    private java.lang.Double rating;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemas.WriterSchema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.surname)) {
        this.surname = data().deepCopy(fields()[2].schema(), other.surname);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.rating)) {
        this.rating = data().deepCopy(fields()[3].schema(), other.rating);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing WriterSchema instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemas.WriterSchema other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.surname)) {
        this.surname = data().deepCopy(fields()[2].schema(), other.surname);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.rating)) {
        this.rating = data().deepCopy(fields()[3].schema(), other.rating);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'nickname' field.
      * @return The value.
      */
    public java.lang.CharSequence getNickname() {
      return nickname;
    }


    /**
      * Sets the value of the 'nickname' field.
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder setNickname(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.nickname = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'nickname' field.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'surname' field.
      * @return The value.
      */
    public java.lang.CharSequence getSurname() {
      return surname;
    }


    /**
      * Sets the value of the 'surname' field.
      * @param value The value of 'surname'.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder setSurname(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.surname = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'surname' field has been set.
      * @return True if the 'surname' field has been set, false otherwise.
      */
    public boolean hasSurname() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'surname' field.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder clearSurname() {
      surname = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'rating' field.
      * @return The value.
      */
    public java.lang.Double getRating() {
      return rating;
    }


    /**
      * Sets the value of the 'rating' field.
      * @param value The value of 'rating'.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder setRating(java.lang.Double value) {
      validate(fields()[3], value);
      this.rating = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'rating' field has been set.
      * @return True if the 'rating' field has been set, false otherwise.
      */
    public boolean hasRating() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'rating' field.
      * @return This builder.
      */
    public com.example.schemas.WriterSchema.Builder clearRating() {
      rating = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WriterSchema build() {
      try {
        WriterSchema record = new WriterSchema();
        record.nickname = fieldSetFlags()[0] ? this.nickname : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.surname = fieldSetFlags()[2] ? this.surname : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.rating = fieldSetFlags()[3] ? this.rating : (java.lang.Double) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WriterSchema>
    WRITER$ = (org.apache.avro.io.DatumWriter<WriterSchema>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WriterSchema>
    READER$ = (org.apache.avro.io.DatumReader<WriterSchema>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.nickname);

    if (this.name == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.name);
    }

    if (this.surname == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.surname);
    }

    if (this.rating == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeDouble(this.rating);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.nickname = in.readString(this.nickname instanceof Utf8 ? (Utf8)this.nickname : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.name = null;
      } else {
        this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.surname = null;
      } else {
        this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.rating = null;
      } else {
        this.rating = in.readDouble();
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.nickname = in.readString(this.nickname instanceof Utf8 ? (Utf8)this.nickname : null);
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.name = null;
          } else {
            this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.surname = null;
          } else {
            this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.rating = null;
          } else {
            this.rating = in.readDouble();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









