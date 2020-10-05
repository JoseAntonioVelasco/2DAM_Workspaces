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
		
          <fo:block font-size="16pt" font-weight="bold" space-after="5mm">
            <xsl:value-of select="ciclo/@nombre"/>
          </fo:block>
		  
          <fo:block font-size="14pt" font-style="italic" space-after="5mm">1º Evaluacion</fo:block>
          <fo:block font-size="10pt" space-after="5mm">
		  
            <fo:table border="solid 0.1mm black">
              <fo:table-column column-width="40mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
              <fo:table-column column-width="10mm"/><fo:table-column column-width="10mm"/>
			  
              <fo:table-header background-color="#F0FFFD">
                <fo:table-cell>
                  <fo:block text-align="center" font-weight="bold">Alumno</fo:block>
                </fo:table-cell>
                <xsl:apply-templates select="//modulo" mode="tabla"/>
              </fo:table-header>
			  
              <fo:table-body>
                <xsl:apply-templates select="//alumnos"/>
              </fo:table-body>
			  
            </fo:table>
          </fo:block>
		  
          <fo:block space-after="5mm">
            <fo:list-block>
              <xsl:apply-templates select="//modulo" mode="lista"/>
            </fo:list-block>
          </fo:block>
		  
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  
  <xsl:template match="//alumnos">
    <xsl:apply-templates/>
  </xsl:template>
  
  <xsl:template match="//alumno">
    <fo:table-row>
      <fo:table-cell border="solid 0.1mm black">
        <fo:block>
          <xsl:value-of select="nombre"/>
        </fo:block>
      </fo:table-cell>
        <xsl:apply-templates/>
    </fo:table-row>
  </xsl:template>
  
  <xsl:template match="//modulo" mode="tabla">
    <fo:table-cell border="solid 0.1mm black">
      <fo:block text-align="center"><xsl:apply-templates select="@id"/></fo:block>
    </fo:table-cell>
  </xsl:template>
  
  <xsl:template match="//modulo" mode="lista">
    <fo:list-item>
      <fo:list-item-label end-indent="label-end()">
        <fo:block>&#x2022;</fo:block>
      </fo:list-item-label>
      <fo:list-item-body start-indent="body-start()">
        <fo:block><xsl:apply-templates select="@id"/>: <xsl:apply-templates/></fo:block>
      </fo:list-item-body>
    </fo:list-item>
  </xsl:template>
  
  <xsl:template match="//calificaciones/calificacion">
    <fo:table-cell border="solid 0.1mm black">
      <fo:block text-align="center">
        <xsl:apply-templates/>
      </fo:block>
    </fo:table-cell>
  </xsl:template>
  
  
</xsl:stylesheet>
