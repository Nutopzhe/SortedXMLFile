<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="transactions">
        <xsl:copy>
            <xsl:for-each select="transaction">
                <xsl:sort select="amount" data-type="number"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
        </xsl:copy>
    </xsl:template>
</xsl:transform>
