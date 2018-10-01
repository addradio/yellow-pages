package net.addradio.services.yellow_pages.factories;

import java.lang.reflect.ParameterizedType;

public class TestFactory<Model> {

    protected Model record;

    public TestFactory() {
        record = createModelInstance();
    }

    public Model build() {
        return record;
    }

    /** NOTE: this is hacky and uses reflection in combination with generics,
     *   which is generally a bad sign (Generics: compile time, Reflection: runtime).
     */
    @SuppressWarnings("unchecked")
    private Model createModelInstance() {
        String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();

        try {
            return (Model) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException error) {
            throw new RuntimeException(error.getLocalizedMessage());
        }
    }

}
