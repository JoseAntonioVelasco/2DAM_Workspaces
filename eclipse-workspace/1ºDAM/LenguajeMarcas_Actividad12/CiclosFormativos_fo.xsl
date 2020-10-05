<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">

  <xsl:template match="/">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
	
		<fo:layout-master-set>
			<fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
				<fo:region-body/>
			</fo:simple-page-master>
		</fo:layout-master-set>
      
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
		  <fo:block font-size="18pt" font-weight="bold" space-after="5mm">
			Grados Superiores Rama: Informatica y comunicacion
		  </fo:block>
		<xsl:for-each select="fp/ciclos/ciclo">
			  <fo:block font-size="10pt" font-weight="bold" space-after="5mm">
				<xsl:value-of select="@siglas" />:&#160;<xsl:value-of select="nombre" />&#160;(<xsl:value-of select="duracion" />&#160;<xsl:value-of select="duracion/@unidad" />)
			  </fo:block>
		  <xsl:variable name="sigla_ciclo" select="@siglas" />
          <fo:block font-size="10pt" space-after="5mm">
		  
            <fo:table border="solid 0.1mm black">
              <fo:table-column column-width="100mm"/><fo:table-column column-width="30mm"/>
              <fo:table-column column-width="20mm"/><fo:table-column column-width="20mm"/>
			  
              <fo:table-header background-color="#d0d0d0">
                <fo:table-cell border="solid 0.4mm black">
                  <fo:block text-align="center" font-weight="bold">Modulo</fo:block>
                </fo:table-cell>
				
				<fo:table-cell border="solid 0.4mm black">
                  <fo:block text-align="center" font-weight="bold">Codigo</fo:block>
                </fo:table-cell>
				
				<fo:table-cell border="solid 0.4mm black">
                  <fo:block text-align="center" font-weight="bold">Duracion</fo:block>
                </fo:table-cell>
				
				<fo:table-cell border="solid 0.4mm black">
                  <fo:block text-align="center" font-weight="bold">Curso</fo:block>
                </fo:table-cell>
              </fo:table-header>
			  
              <fo:table-body>
                <xsl:for-each select="//modulos/modulo">
											
							<xsl:for-each select="ciclos/ciclo">
							
								<xsl:if test="@siglas = $sigla_ciclo">
									<fo:table-row>
									
										<fo:table-cell border="solid 0.4mm black" padding="0.5mm">
											<fo:block>
												<xsl:value-of select="../../nombre" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell border="solid 0.4mm black" padding="0.5mm">
											<fo:block>
												<xsl:value-of select="../../@codigo" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell border="solid 0.4mm black" padding="0.5mm">
											<fo:block>
												<xsl:value-of select="../../duracion" />h
											</fo:block>
										</fo:table-cell>
										<fo:table-cell border="solid 0.4mm black" padding="0.5mm">
											<fo:block>
												<xsl:value-of select="../../curso" />
											</fo:block>
										</fo:table-cell>
										
									</fo:table-row>
								</xsl:if>
								
							</xsl:for-each>
						</xsl:for-each>
              </fo:table-body>
			  
            </fo:table>
          </fo:block>
		</xsl:for-each>
		  
		  
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
 
</xsl:stylesheet>
