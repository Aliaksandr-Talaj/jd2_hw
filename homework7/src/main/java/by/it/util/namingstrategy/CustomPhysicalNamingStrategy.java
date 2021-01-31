package by.it.util.namingstrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        final String postfix = "_TAB";

        return addPostfix(identifier, postfix);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        final String postfix = "_SEC";

        return addPostfix(identifier, postfix);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        final String postfix = "_COL";

        return addPostfix(identifier, postfix);
    }

    private Identifier addPostfix(final Identifier identifier, final String postfix) {
        final String newIdentifier = identifier.getText() + postfix;

        return Identifier.toIdentifier(newIdentifier);
    }

}




